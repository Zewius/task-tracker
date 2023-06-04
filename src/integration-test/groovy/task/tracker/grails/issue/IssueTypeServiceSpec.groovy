package task.tracker.grails.issue

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class IssueTypeServiceSpec extends Specification {

    IssueTypeService issueTypeService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new IssueType(...).save(flush: true, failOnError: true)
        //new IssueType(...).save(flush: true, failOnError: true)
        //IssueType issueType = new IssueType(...).save(flush: true, failOnError: true)
        //new IssueType(...).save(flush: true, failOnError: true)
        //new IssueType(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //issueType.id
    }

    void "test get"() {
        setupData()

        expect:
        issueTypeService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<IssueType> issueTypeList = issueTypeService.list(max: 2, offset: 2)

        then:
        issueTypeList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        issueTypeService.count() == 5
    }

    void "test delete"() {
        Long issueTypeId = setupData()

        expect:
        issueTypeService.count() == 5

        when:
        issueTypeService.delete(issueTypeId)
        sessionFactory.currentSession.flush()

        then:
        issueTypeService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        IssueType issueType = new IssueType()
        issueTypeService.save(issueType)

        then:
        issueType.id != null
    }
}
