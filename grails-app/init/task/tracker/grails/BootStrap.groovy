package task.tracker.grails

import task.tracker.grails.issue.IssueStage
import task.tracker.grails.issue.IssueType
import task.tracker.grails.programmer.Programmer
import task.tracker.grails.programmer.ProgrammerPosition
import task.tracker.grails.project.Project
import task.tracker.grails.task.Task
import task.tracker.grails.tester.Tester
import task.tracker.grails.tester.TesterPosition

class BootStrap {

    def init = { servletContext ->

        // Заполнение приложения тестовыми данными
        def leadTester = new TesterPosition(name: "Ведущий тестировщик").save()
        def seniorTester = new TesterPosition(name: "Старший тестировщик").save()
        def juniorTester = new TesterPosition(name: "Младший тестировщик").save()

        def tester1 = new Tester(firstName: "Михаил", lastName: "Михайлов", position: leadTester).save()
        def tester2 = new Tester(firstName: "Иван", lastName: "Иванов", position: seniorTester).save()
        def tester3 = new Tester(firstName: "Петр", lastName: "Петров", position: juniorTester).save()

        def leadProgrammer = new ProgrammerPosition(name: "Ведущий разработчик").save()
        def seniorProgrammer = new ProgrammerPosition(name: "Старший разработчик").save()
        def juniorProgrammer = new ProgrammerPosition(name: "Младший разработчик").save()

        def programmer1 = new Programmer(firstName: "Сергей", lastName: "Красилов", position: leadProgrammer).save()
        def programmer2 = new Programmer(firstName: "Николай", lastName: "Басков", position: leadProgrammer).save()
        def programmer3 = new Programmer(firstName: "Филипп", lastName: "Киркоров", position: seniorProgrammer).save()
        def programmer4 = new Programmer(firstName: "Рулон", lastName: "Обоев", position: juniorProgrammer).save()
        // Заполнение приложения тестовыми данными

        // Не удалять - важно
        def cosmeticFlaw = new IssueType(name: "Косметический дефект").save()
        def dataCorruption = new IssueType(name: "Повреждение / потеря данных").save()
        def documentationIssue = new IssueType(name: "Проблема в документации").save()
        def incorrectOperation = new IssueType(name: "Некорректная операция").save()
        def installationProblem = new IssueType(name: "Проблема инсталляции").save()
        def localizationIssue = new IssueType(name: "Ошибка локализации").save()
        def missingFeature = new IssueType(name: "Нереализованная функциональность").save()
        def scalability = new IssueType(name: "Проблема масштабируемости").save()
        def lowPerformance = new IssueType(name: "Низкая производительность").save()
        def systemCrash = new IssueType(name: "Крах системы").save()
        // Не удалять - важно

        // Заполнение приложения тестовыми данными
        def fitnessApp = new Project(
                name: "Фитнес на каждый день",
                description: "Разработка мобильного приложения для тренировок",
                creationDate: new Date(2022, 3, 15),
                completionDate: new Date(2023, 5, 30)
        ).save()

        def task1 = new Task(
                project: fitnessApp,
                issueType: missingFeature,
                name: "Добавить функцию расчета калорий",
                description: "Необходимо добавить функцию расчета суточной нормы калорий и отображением количества потраченных калорий во время тренировки",
                programmer: programmer1,
                tester: tester1,
                creationDate: new Date(2022, 5, 25),
                deadline: new Date(2022, 6, 15)
        ).save()

        def task2 = new Task(
                project: fitnessApp,
                issueType: incorrectOperation,
                name: "Исправить ошибку с входом в приложение",
                description: "Приложение не позволяет некоторым пользователям войти в свой аккаунт",
                programmer: programmer2,
                tester: tester2,
                creationDate: new Date(2022, 7, 3),
                deadline: new Date(2022, 7, 6)
        ).save()

        def task3 = new Task(
                project: fitnessApp,
                issueType: lowPerformance,
                name: "Оптимизировать загрузку изображений",
                description: "Загрузка изображений на экран тренировок занимает слишком много времени",
                programmer: programmer3,
                tester: tester3,
                creationDate: new Date(2022, 7, 15),
                deadline: new Date(2022, 7, 30)
        ).save()

        def task4 = new Task(
                project: fitnessApp,
                issueType: scalability,
                name: "Поддержка большего количества пользователей",
                description: "Приложение начинает тормозить при увеличении количества пользователей",
                programmer: programmer1,
                tester: tester2,
                creationDate: new Date(2022, 9, 1),
                deadline: new Date(2022, 9, 15)
        ).save()

        def task5 = new Task(
                project: fitnessApp,
                issueType: dataCorruption,
                name: "Исправить проблему с сохранением фотографий",
                description: "Приложение случайно теряет фотографии, загруженные пользователями",
                programmer: programmer3,
                tester: tester2,
                creationDate: new Date(2022, 10, 1),
                deadline: new Date(2022, 10, 10)
        ).save()

        def task6 = new Task(
                project: fitnessApp,
                issueType: installationProblem,
                name: "Исправить проблему с установкой на Android 11",
                description: "Приложение не устанавливается на устройствах Android 11",
                programmer: programmer2,
                tester: tester1,
                creationDate: new Date(2022, 11, 1),
                deadline: new Date(2022, 11, 3)
        ).save()

        def task7 = new Task(
                project: fitnessApp,
                issueType: documentationIssue,
                name: "Обновить руководство пользователя",
                description: "Руководство пользователя устарело и содержит неточности",
                programmer: programmer1,
                tester: tester2,
                creationDate: new Date(2022, 12, 1),
                deadline: new Date(2022, 12, 5)
        ).save()

        def task8 = new Task(
                project: fitnessApp,
                issueType: cosmeticFlaw,
                name: "Изменить дизайн экрана настроек",
                description: "Необходимо изменить дизайн экрана настроек, чтобы он лучше соответствовал общему стилю приложения",
                programmer: programmer4,
                tester: tester2,
                creationDate: new Date(2023, 1, 1),
                deadline: new Date(2023, 1, 3)
        ).save()

        def task9 = new Task(
                project: fitnessApp,
                issueType: missingFeature,
                name: "Добавить функцию записей",
                description: "Необходимо добавить возможность вести записи о выполненных тренировках",
                programmer: programmer3,
                tester: tester3,
                creationDate: new Date(2023, 2, 1),
                deadline: new Date(2023, 2, 5)
        ).save()

        def task10 = new Task(
                project: fitnessApp,
                issueType: lowPerformance,
                name: "Оптимизировать поиск по базе данных",
                description: "Поиск по базе данных пользователей и тренировок занимает слишком много времени",
                programmer: programmer1,
                tester: tester2,
                creationDate: new Date(2023, 3, 1),
                deadline: new Date(2023, 3, 10)
        ).save()

        def task11 = new Task(
                project: fitnessApp,
                issueType: localizationIssue,
                name: "Исправить ошибки в переводе на испанский язык",
                description: "Некоторые фразы в переводе на испанский язык переведены некорректно",
                programmer: programmer2,
                tester: tester1,
                creationDate: new Date(2023, 4, 1),
                deadline: new Date(2023, 4, 3)
        ).save()

        def task12 = new Task(
                project: fitnessApp,
                issueType: systemCrash,
                name: "Исправить проблему с зависанием приложения",
                description: "Приложение случайно зависает при работе",
                programmer: programmer3,
                tester: tester2,
                creationDate: new Date(2023, 5, 1),
                deadline: new Date(2023, 5, 3)
        ).save()

        def task13 = new Task(
                project: fitnessApp,
                issueType: missingFeature,
                name: "Добавить календарь тренировок",
                description: "Необходимо добавить функцию отображения календаря выполненных или запланированных тренировок",
                programmer: programmer4,
                tester: tester3,
                creationDate: new Date(2023, 6, 1),
                deadline: new Date(2023, 6, 7)
        ).save()

        def task14 = new Task(
                project: fitnessApp,
                issueType: incorrectOperation,
                name: "Исправить проблему с отображением времени",
                description: "Приложение отображает некорректное время на нескольких экранах",
                programmer: programmer1,
                tester: tester2,
                creationDate: new Date(2023, 7, 1),
                deadline: new Date(2023, 7, 3)
        ).save()

        def task15 = new Task(
                project: fitnessApp,
                issueType: scalability,
                name: "Улучшить масштабируемость приложения",
                description: "Приложение не масштабируется при сверхбольшом количестве пользователей",
                programmer: programmer2,
                tester: tester3,
                creationDate: new Date(2023, 8, 1),
                deadline: new Date(2023, 8, 15)
        ).save()

        def task16 = new Task(
                project: fitnessApp,
                issueType: dataCorruption,
                name: "Исправить проблему с сохранением данных о тренировках",
                description: "Приложение случайно теряет данные о выполненных тренировках",
                programmer: programmer1,
                tester: tester2,
                creationDate: new Date(2023, 9, 1),
                deadline: new Date(2023, 9, 5)
        ).save()

        def task17 = new Task(
                project: fitnessApp,
                issueType: lowPerformance,
                name: "Увеличить скорость загрузки приложения",
                description: "Приложение загружается слишком долго на некоторых устройствах",
                programmer: programmer3,
                tester: tester1,
                creationDate: new Date(2023, 10, 1),
                deadline: new Date(2023, 10, 3)
        ).save()

        def task18 = new Task(
                project: fitnessApp,
                issueType: installationProblem,
                name: "Исправить проблему с установкой на iOS 15",
                description: "Приложение не устанавливается на устройствах iOS 15",
                programmer: programmer4,
                tester: tester2,
                creationDate: new Date(2023, 11, 1),
                deadline: new Date(2023, 11, 5)
        ).save()

        def task19 = new Task(
                project: fitnessApp,
                issueType: missingFeature,
                name: "Добавить функцию мотивации",
                description: "Необходимо добавить функцию мотивации пользователей к выполнению тренировок",
                programmer: programmer1,
                tester: tester3,
                creationDate: new Date(2023, 12, 1),
                deadline: new Date(2023, 12, 7)
        ).save()

        def task20 = new Task(
                project: fitnessApp,
                issueType: incorrectOperation,
                name: "Исправить ошибку с подсчетом тренировок",
                description: "Приложение неправильно подсчитывает количество выполненных тренировок",
                programmer: programmer2,
                tester: tester1,
                creationDate: new Date(2024, 1, 1),
                deadline: new Date(2024, 1, 3)
        ).save()

        def taskStage1 = new IssueStage(name: 'Открыта').save()
        def taskStage2 = new IssueStage(name: 'Анализ').save()
        def taskStage3 = new IssueStage(name: 'В плане').save()
        def taskStage4 = new IssueStage(name: 'Назначена').save()
        def taskStage5 = new IssueStage(name: 'В работе').save()
        def taskStage6 = new IssueStage(name: 'На ревью').save()
        def taskStage7 = new IssueStage(name: 'На тестировании').save()
        def taskStage8 = new IssueStage(name: 'Закрыта').save()

        // Заполнение приложения тестовыми данными

    }

    def destroy = {
    }
}
