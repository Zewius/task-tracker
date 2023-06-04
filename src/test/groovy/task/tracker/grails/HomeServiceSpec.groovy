package task.tracker.grails

import grails.testing.services.ServiceUnitTest
import spock.lang.Specification
import task.tracker.grails.home.HomeService

class HomeServiceSpec extends Specification implements ServiceUnitTest<HomeService>{

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
        expect:"fix me"
            true == false
    }
}
