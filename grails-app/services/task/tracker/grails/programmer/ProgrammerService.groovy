package task.tracker.grails.programmer

import grails.gorm.services.Service

@Service(Programmer)
interface ProgrammerService {

    Programmer get(Serializable id)

    List<Programmer> list(Map args)

    Long count()

    void delete(Serializable id)

    Programmer save(Programmer programmer)

}