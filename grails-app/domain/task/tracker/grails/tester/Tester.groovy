package task.tracker.grails.tester

class Tester {

    String firstName
    String lastName
    String description
    TesterPosition position

    static belongsTo = [
            position: TesterPosition
    ]

    static constraints = {
        firstName nullable: false
        lastName nullable: false
        description nullable: true
        position nullable: false
    }

    @Override
    String toString() {
        return "$lastName $firstName [$position]";
    }
}
