package task.tracker.grails.issue

import grails.gorm.services.Service

@Service(IssueType)
interface IssueTypeService {

    IssueType get(Serializable id)

    List<IssueType> list(Map args)

    Long count()

    void delete(Serializable id)

    IssueType save(IssueType issueType)

}