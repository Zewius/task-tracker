package task.tracker.grails.tester

import grails.gorm.services.Service

@Service(TesterPosition)
interface TesterPositionService {

    TesterPosition get(Serializable id)

    List<TesterPosition> list(Map args)

    Long count()

    void delete(Serializable id)

    TesterPosition save(TesterPosition testerPosition)

}