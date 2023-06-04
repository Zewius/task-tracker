package task.tracker.grails.programmer

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class ProgrammerController {

    ProgrammerService programmerService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond programmerService.list(params), model:[programmerCount: programmerService.count()]
    }

    def show(Long id) {
        respond programmerService.get(id)
    }

    def create() {
        respond new Programmer(params)
    }

    def save(Programmer programmer) {
        if (programmer == null) {
            notFound()
            return
        }

        try {
            programmerService.save(programmer)
        } catch (ValidationException e) {
            respond programmer.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'programmer.label', default: 'Programmer'), programmer.id])
                redirect programmer
            }
            '*' { respond programmer, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond programmerService.get(id)
    }

    def update(Programmer programmer) {
        if (programmer == null) {
            notFound()
            return
        }

        try {
            programmerService.save(programmer)
        } catch (ValidationException e) {
            respond programmer.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'programmer.label', default: 'Programmer'), programmer.id])
                redirect programmer
            }
            '*'{ respond programmer, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        programmerService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'programmer.label', default: 'Programmer'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'programmer.label', default: 'Programmer'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
