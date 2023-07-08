package task.tracker.grails.issue

import grails.gorm.services.Service

@Service(IssueStage)
interface IssueStageService {

    IssueStage get(Serializable id)

    List<IssueStage> list(Map args)

    Long count()

    void delete(Serializable id)

    IssueStage save(IssueStage issueStage)

}