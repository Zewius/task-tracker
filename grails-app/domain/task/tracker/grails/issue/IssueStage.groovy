package task.tracker.grails.issue

class IssueStage {

    String name
    String description

    static constraints = {
        name        nullable: false, unique: true
        description nullable: true
    }

    @Override
    String toString() {
        return name
    }
}
