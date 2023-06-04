package task.tracker.grails.tester

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class TesterPositionServiceSpec extends Specification {

    TesterPositionService testerPositionService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new TesterPosition(...).save(flush: true, failOnError: true)
        //new TesterPosition(...).save(flush: true, failOnError: true)
        //TesterPosition testerPosition = new TesterPosition(...).save(flush: true, failOnError: true)
        //new TesterPosition(...).save(flush: true, failOnError: true)
        //new TesterPosition(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //testerPosition.id
    }

    void "test get"() {
        setupData()

        expect:
        testerPositionService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<TesterPosition> testerPositionList = testerPositionService.list(max: 2, offset: 2)

        then:
        testerPositionList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        testerPositionService.count() == 5
    }

    void "test delete"() {
        Long testerPositionId = setupData()

        expect:
        testerPositionService.count() == 5

        when:
        testerPositionService.delete(testerPositionId)
        sessionFactory.currentSession.flush()

        then:
        testerPositionService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        TesterPosition testerPosition = new TesterPosition()
        testerPositionService.save(testerPosition)

        then:
        testerPosition.id != null
    }
}
