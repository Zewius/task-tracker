package task.tracker.grails.issue

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class IssueTypeController {

    IssueTypeService issueTypeService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond issueTypeService.list(params), model:[issueTypeCount: issueTypeService.count()]
    }

    def show(Long id) {
        respond issueTypeService.get(id)
    }

    def create() {
        respond new IssueType(params)
    }

    def save(IssueType issueType) {
        if (issueType == null) {
            notFound()
            return
        }

        try {
            issueTypeService.save(issueType)
        } catch (ValidationException e) {
            respond issueType.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'issueType.label', default: 'IssueType'), issueType.id])
                redirect issueType
            }
            '*' { respond issueType, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond issueTypeService.get(id)
    }

    def update(IssueType issueType) {
        if (issueType == null) {
            notFound()
            return
        }

        try {
            issueTypeService.save(issueType)
        } catch (ValidationException e) {
            respond issueType.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'issueType.label', default: 'IssueType'), issueType.id])
                redirect issueType
            }
            '*'{ respond issueType, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        issueTypeService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'issueType.label', default: 'IssueType'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'issueType.label', default: 'IssueType'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
