package task.tracker.grails.task

import task.tracker.grails.issue.IssueType
import task.tracker.grails.programmer.Programmer
import task.tracker.grails.project.Project
import task.tracker.grails.tester.Tester

class Task {

    Project project
    IssueType issueType
    String name
    String description
    Programmer programmer
    Tester tester
    Date creationDate
    Date deadline

    static belongsTo = [
            project: Project,
            issueType: IssueType
    ]

    static constraints = {
        project nullable: false
        issueType nullable: false
        name nullable: false
        description nullable: false
        programmer nullable: false
        tester nullable: false
        creationDate nullable: false
        deadline nullable: false
    }

    @Override
    String toString() {
        return "[$project] $name";
    }
}
