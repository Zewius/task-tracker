package task.tracker.grails.tester

import grails.gorm.services.Service

@Service(Tester)
interface TesterService {

    Tester get(Serializable id)

    List<Tester> list(Map args)

    Long count()

    void delete(Serializable id)

    Tester save(Tester tester)

}