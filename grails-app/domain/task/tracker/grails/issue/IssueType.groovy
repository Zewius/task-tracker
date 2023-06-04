package task.tracker.grails.issue

class IssueType {

    String name

    static constraints = {
        name nullable: false
    }

    @Override
    String toString() {
        return name;
    }
}
