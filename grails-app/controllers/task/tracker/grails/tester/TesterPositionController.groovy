package task.tracker.grails.tester

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class TesterPositionController {

    TesterPositionService testerPositionService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond testerPositionService.list(params), model:[testerPositionCount: testerPositionService.count()]
    }

    def show(Long id) {
        respond testerPositionService.get(id)
    }

    def create() {
        respond new TesterPosition(params)
    }

    def save(TesterPosition testerPosition) {
        if (testerPosition == null) {
            notFound()
            return
        }

        try {
            testerPositionService.save(testerPosition)
        } catch (ValidationException e) {
            respond testerPosition.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'testerPosition.label', default: 'TesterPosition'), testerPosition.id])
                redirect testerPosition
            }
            '*' { respond testerPosition, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond testerPositionService.get(id)
    }

    def update(TesterPosition testerPosition) {
        if (testerPosition == null) {
            notFound()
            return
        }

        try {
            testerPositionService.save(testerPosition)
        } catch (ValidationException e) {
            respond testerPosition.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'testerPosition.label', default: 'TesterPosition'), testerPosition.id])
                redirect testerPosition
            }
            '*'{ respond testerPosition, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        testerPositionService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'testerPosition.label', default: 'TesterPosition'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'testerPosition.label', default: 'TesterPosition'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
