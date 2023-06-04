package task.tracker.grails.programmer

import grails.gorm.services.Service

@Service(ProgrammerPosition)
interface ProgrammerPositionService {

    ProgrammerPosition get(Serializable id)

    List<ProgrammerPosition> list(Map args)

    Long count()

    void delete(Serializable id)

    ProgrammerPosition save(ProgrammerPosition programmerPosition)

}