package task.tracker.grails.home

class HomeController {

    HomeService homeService

    def index() {
        render(view: "index", model: [
                projectCounts   : homeService.countTasksByProject(),
                issueCounts     : homeService.countTasksByIssueType(),
                programmerCounts: homeService.countTasksByProgrammer(),
                testerCounts    : homeService.countTasksByTester()
        ])
    }
}
