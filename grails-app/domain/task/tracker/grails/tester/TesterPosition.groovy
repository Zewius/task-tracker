package task.tracker.grails.tester

class TesterPosition {

    String name;
    String description;

    static constraints = {
        name nullable: false
        description nullable: true
    }

    @Override
    String toString() {
        return name;
    }
}
