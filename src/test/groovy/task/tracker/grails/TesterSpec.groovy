package task.tracker.grails

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification
import task.tracker.grails.tester.Tester

class TesterSpec extends Specification implements DomainUnitTest<Tester> {

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
        expect:"fix me"
            true == false
    }
}
