package task.tracker.grails.programmer

class Programmer {

    String firstName
    String lastName
    String description
    ProgrammerPosition position

    static belongsTo = [
            position: ProgrammerPosition
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
