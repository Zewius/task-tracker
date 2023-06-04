package task.tracker.grails.programmer

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class ProgrammerServiceSpec extends Specification {

    ProgrammerService programmerService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Programmer(...).save(flush: true, failOnError: true)
        //new Programmer(...).save(flush: true, failOnError: true)
        //Programmer programmer = new Programmer(...).save(flush: true, failOnError: true)
        //new Programmer(...).save(flush: true, failOnError: true)
        //new Programmer(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //programmer.id
    }

    void "test get"() {
        setupData()

        expect:
        programmerService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Programmer> programmerList = programmerService.list(max: 2, offset: 2)

        then:
        programmerList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        programmerService.count() == 5
    }

    void "test delete"() {
        Long programmerId = setupData()

        expect:
        programmerService.count() == 5

        when:
        programmerService.delete(programmerId)
        sessionFactory.currentSession.flush()

        then:
        programmerService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Programmer programmer = new Programmer()
        programmerService.save(programmer)

        then:
        programmer.id != null
    }
}
