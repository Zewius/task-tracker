<%--
  Created by IntelliJ IDEA.
  User: Zewius
  Date: 04.06.2023
  Time: 16:51
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main"/>
    <title><g:message code="home.label"/></title>
</head>

<body>
<div id="content" role="main">
    <div class="container">
        <section class="row">
            <div class="col-12 content scaffold-list" role="main">
                <div class="text-center h2">
                    <h1><g:message code="home.label"/></h1>
                </div>

                <g:if test="${flash.message}">
                    <div class="message" role="status">${flash.message}</div>
                </g:if>
            </div>
        </section>
        <section class="row">
            <div class="col-12 content" role="main">
                <div>
                    <table>
                        <thead>
                        <tr>
                            <th>Проект</th>
                            <th>Количество задач</th>
                        </tr>
                        </thead>
                        <tbody>
                        <g:each in="${projectCounts}" var="projectCount">
                            <tr>
                                <td>
                                    <g:link controller="project" action="show" id="${projectCount[0].id}">
                                        ${projectCount[0]}
                                    </g:link>
                                </td>
                                <td>${projectCount[1]}</td>
                            </tr>
                        </g:each>
                        </tbody>
                    </table>
                </div>

                <div>
                    <table>
                        <thead>
                        <tr>
                            <th>Тип ошибки</th>
                            <th>Количество задач</th>
                        </tr>
                        </thead>
                        <tbody>
                        <g:each in="${issueCounts}" var="issueCount">
                            <tr>
                                <td>
                                    <g:link controller="issueType" action="show" id="${issueCount[0].id}">
                                        ${issueCount[0]}
                                    </g:link>
                                </td>
                                <td>${issueCount[1]}</td>
                            </tr>
                        </g:each>
                        </tbody>
                    </table>
                </div>

                <div>
                    <table>
                        <thead>
                        <tr>
                            <th>Программист</th>
                            <th>Количество задач</th>
                        </tr>
                        </thead>
                        <tbody>
                        <g:each in="${programmerCounts}" var="programmerCount">
                            <tr>
                                <td>
                                    <g:link controller="programmer" action="show" id="${programmerCount[0].id}">
                                        ${programmerCount[0]}
                                    </g:link>
                                </td>
                                <td>${programmerCount[1]}</td>
                            </tr>
                        </g:each>
                        </tbody>
                    </table>
                </div>

                <div>
                    <table>
                        <thead>
                        <tr>
                            <th>Тестировщик</th>
                            <th>Количество задач</th>
                        </tr>
                        </thead>
                        <tbody>
                        <g:each in="${testerCounts}" var="testerCount">
                            <tr>
                                <td>
                                    <g:link controller="tester" action="show" id="${testerCount[0].id}">
                                        ${testerCount[0]}
                                    </g:link>
                                </td>
                                <td>${testerCount[1]}</td>
                            </tr>
                        </g:each>
                        </tbody>
                    </table>
                </div>
            </div>
        </section>
    </div>
</div>
</body>
</html>
