package task.tracker.grails.project

class Project {

    String name
    String description
    Date creationDate
    Date completionDate

    static constraints = {
        name nullable: false
        description nullable: false
        creationDate nullable: false
        completionDate nullable: false
    }

    @Override
    String toString() {
        return name;
    }
}
