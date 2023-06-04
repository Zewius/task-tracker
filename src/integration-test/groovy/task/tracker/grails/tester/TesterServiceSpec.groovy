package task.tracker.grails.tester

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class TesterServiceSpec extends Specification {

    TesterService testerService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Tester(...).save(flush: true, failOnError: true)
        //new Tester(...).save(flush: true, failOnError: true)
        //Tester tester = new Tester(...).save(flush: true, failOnError: true)
        //new Tester(...).save(flush: true, failOnError: true)
        //new Tester(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //tester.id
    }

    void "test get"() {
        setupData()

        expect:
        testerService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Tester> testerList = testerService.list(max: 2, offset: 2)

        then:
        testerList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        testerService.count() == 5
    }

    void "test delete"() {
        Long testerId = setupData()

        expect:
        testerService.count() == 5

        when:
        testerService.delete(testerId)
        sessionFactory.currentSession.flush()

        then:
        testerService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Tester tester = new Tester()
        testerService.save(tester)

        then:
        tester.id != null
    }
}
