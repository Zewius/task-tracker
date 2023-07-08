package task.tracker.grails.issue

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class IssueStageController {

    IssueStageService issueStageService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond issueStageService.list(params), model:[issueStageCount: issueStageService.count()]
    }

    def show(Long id) {
        respond issueStageService.get(id)
    }

    def create() {
        respond new IssueStage(params)
    }

    def save(IssueStage issueStage) {
        if (issueStage == null) {
            notFound()
            return
        }

        try {
            issueStageService.save(issueStage)
        } catch (ValidationException e) {
            respond issueStage.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'issueStage.label', default: 'IssueStage'), issueStage.id])
                redirect issueStage
            }
            '*' { respond issueStage, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond issueStageService.get(id)
    }

    def update(IssueStage issueStage) {
        if (issueStage == null) {
            notFound()
            return
        }

        try {
            issueStageService.save(issueStage)
        } catch (ValidationException e) {
            respond issueStage.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'issueStage.label', default: 'IssueStage'), issueStage.id])
                redirect issueStage
            }
            '*'{ respond issueStage, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        issueStageService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'issueStage.label', default: 'IssueStage'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'issueStage.label', default: 'IssueStage'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
