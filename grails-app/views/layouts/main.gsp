<!doctype html>
<html lang="en" class="no-js">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <title>
    <g:layoutTitle default="Grails"/>
    </title>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <asset:link rel="icon" href="favicon.ico" type="image/x-ico"/>

    <asset:stylesheet src="application.css"/>

    <g:layoutHead/>
</head>

<body>

<nav class="navbar navbar-expand-lg navbar-dark navbar-static-top" role="navigation">
    <div class="container-fluid">
        <a class="navbar-brand" href="/">Панель управления проектами</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarContent"
                aria-controls="navbarContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" aria-expanded="false" style="height: 0.8px;" id="navbarContent">
            <ul class="nav navbar-nav ml-auto">
                <li>
                    <g:link controller="task" action="index">
                        <g:message code="nav.task.label"/>
                    </g:link>
                </li>
                <li>
                    <g:link controller="project" action="index">
                        <g:message code="nav.project.label"/>
                    </g:link>
                </li>
                <li>
                    <g:link controller="issueType" action="index">
                        <g:message code="nav.issueType.label"/>
                    </g:link>
                </li>
                <li>
                    <g:link controller="issueStage" action="index">
                        <g:message code="nav.issueStage.label"/>
                    </g:link>
                </li>
                <li>
                    <g:link controller="programmer" action="index">
                        <g:message code="nav.programmer.label"/>
                    </g:link>
                </li>
                <li>
                    <g:link controller="programmerPosition" action="index">
                        <g:message code="nav.programmerPosition.label"/>
                    </g:link>
                </li>
                <li>
                    <g:link controller="tester" action="index">
                        <g:message code="nav.tester.label"/>
                    </g:link>
                </li>
                <li>
                    <g:link controller="testerPosition" action="index">
                        <g:message code="nav.testerPosition.label"/>
                    </g:link>
                </li>
            </ul>
        </div>
    </div>
</nav>

<g:layoutBody/>

<div id="spinner" class="spinner" style="display:none;">
    <g:message code="spinner.alt" default="Loading&hellip;"/>
</div>

<asset:javascript src="application.js"/>

</body>
</html>
