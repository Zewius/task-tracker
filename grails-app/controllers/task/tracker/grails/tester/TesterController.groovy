package task.tracker.grails.tester

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class TesterController {

    TesterService testerService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond testerService.list(params), model:[testerCount: testerService.count()]
    }

    def show(Long id) {
        respond testerService.get(id)
    }

    def create() {
        respond new Tester(params)
    }

    def save(Tester tester) {
        if (tester == null) {
            notFound()
            return
        }

        try {
            testerService.save(tester)
        } catch (ValidationException e) {
            respond tester.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'tester.label', default: 'Tester'), tester.id])
                redirect tester
            }
            '*' { respond tester, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond testerService.get(id)
    }

    def update(Tester tester) {
        if (tester == null) {
            notFound()
            return
        }

        try {
            testerService.save(tester)
        } catch (ValidationException e) {
            respond tester.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'tester.label', default: 'Tester'), tester.id])
                redirect tester
            }
            '*'{ respond tester, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        testerService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'tester.label', default: 'Tester'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'tester.label', default: 'Tester'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
