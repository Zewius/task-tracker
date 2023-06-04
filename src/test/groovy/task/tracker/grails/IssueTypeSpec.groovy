package task.tracker.grails

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification
import task.tracker.grails.issue.IssueType

class IssueTypeSpec extends Specification implements DomainUnitTest<IssueType> {

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
        expect:"fix me"
            true == false
    }
}
