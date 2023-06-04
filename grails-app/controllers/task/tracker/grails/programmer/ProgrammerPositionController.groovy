package task.tracker.grails.programmer

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class ProgrammerPositionController {

    ProgrammerPositionService programmerPositionService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond programmerPositionService.list(params), model:[programmerPositionCount: programmerPositionService.count()]
    }

    def show(Long id) {
        respond programmerPositionService.get(id)
    }

    def create() {
        respond new ProgrammerPosition(params)
    }

    def save(ProgrammerPosition programmerPosition) {
        if (programmerPosition == null) {
            notFound()
            return
        }

        try {
            programmerPositionService.save(programmerPosition)
        } catch (ValidationException e) {
            respond programmerPosition.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'programmerPosition.label', default: 'ProgrammerPosition'), programmerPosition.id])
                redirect programmerPosition
            }
            '*' { respond programmerPosition, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond programmerPositionService.get(id)
    }

    def update(ProgrammerPosition programmerPosition) {
        if (programmerPosition == null) {
            notFound()
            return
        }

        try {
            programmerPositionService.save(programmerPosition)
        } catch (ValidationException e) {
            respond programmerPosition.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'programmerPosition.label', default: 'ProgrammerPosition'), programmerPosition.id])
                redirect programmerPosition
            }
            '*'{ respond programmerPosition, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        programmerPositionService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'programmerPosition.label', default: 'ProgrammerPosition'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'programmerPosition.label', default: 'ProgrammerPosition'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
