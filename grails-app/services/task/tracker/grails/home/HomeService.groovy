package task.tracker.grails.home

import grails.gorm.transactions.ReadOnly
import task.tracker.grails.task.Task


class HomeService {

    @ReadOnly
    def countTasksByProject() {
        def c = Task.createCriteria()
        def results = c {
            projections {
                groupProperty('project')
                count('project', 'taskCount')
            }
            order('taskCount', 'desc')
        }

        return results
    }

    @ReadOnly
    def countTasksByIssueType() {
        def c = Task.createCriteria()
        def results = c {
            projections {
                groupProperty('issueType')
                count('issueType', 'taskCount')
            }
            order('taskCount', 'desc')
        }

        return results
    }

    @ReadOnly
    def countTasksByProgrammer() {
        def c = Task.createCriteria()
        def results = c {
            projections {
                groupProperty('programmer')
                count('programmer', 'taskCount')
            }
            order('taskCount', 'desc')
        }

        return results
    }

    @ReadOnly
    def countTasksByTester() {
        def c = Task.createCriteria()
        def results = c {
            projections {
                groupProperty('tester')
                count('tester', 'taskCount')
            }
            order('taskCount', 'desc')
        }

        return results
    }
}
