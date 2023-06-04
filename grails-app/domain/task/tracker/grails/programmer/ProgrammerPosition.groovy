package task.tracker.grails.programmer

class ProgrammerPosition {

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
