<!doctype html>
<html>
    <head>
        <title>Страница не найдена</title>
        <meta name="layout" content="main">
        <g:if env="development"><asset:stylesheet src="errors.css"/></g:if>
    </head>
    <body>
    <div id="content" role="main">
        <div class="container">
            <section class="row">
                <ul class="col-12 errors">
                    <li>Ошибка: страница не найдена</li>
                    <li>Путь: ${request.forwardURI}</li>
                </ul>
            </section>
        </div>
    </div>
    </body>
</html>
