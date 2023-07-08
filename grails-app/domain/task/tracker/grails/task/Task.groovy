package task.tracker.grails.task

import task.tracker.grails.issue.IssueStage
import task.tracker.grails.issue.IssueType
import task.tracker.grails.programmer.Programmer
import task.tracker.grails.project.Project
import task.tracker.grails.tester.Tester

class Task {

    Project project
    IssueType issueType
    String name
    String description
    IssueStage issueStage
    Programmer programmer
    Tester tester
    Date creationDate
    Date deadline

    static belongsTo = [
            project: Project,
            issueType: IssueType,
            issueStage: IssueStage
    ]

    static constraints = {
        project         nullable: false
        issueType       nullable: false
        issueStage      nullable: true
        name            nullable: false
        description     nullable: false
        programmer      nullable: false
        tester          nullable: true
        creationDate    nullable: false
        deadline        nullable: true
    }

    @Override
    String toString() {
        return "[$project] $name";
    }
}
