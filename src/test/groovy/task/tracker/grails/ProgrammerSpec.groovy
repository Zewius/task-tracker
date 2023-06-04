package task.tracker.grails

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification
import task.tracker.grails.programmer.Programmer

class ProgrammerSpec extends Specification implements DomainUnitTest<Programmer> {

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
        expect:"fix me"
            true == false
    }
}
