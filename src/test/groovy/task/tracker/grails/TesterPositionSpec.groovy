package task.tracker.grails

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification
import task.tracker.grails.tester.TesterPosition

class TesterPositionSpec extends Specification implements DomainUnitTest<TesterPosition> {

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
        expect:"fix me"
            true == false
    }
}
