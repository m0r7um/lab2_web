<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">

    <meta name="author" content="Вальц Мартин Эдуардович">
    <meta name="description" content="Веб-2">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/stylesheets/styles.css"/>
    <title>Лабораторная работа №2 | Веб-программирование v0.2</title>
</head>

<body>
<jsp:include page="header.html"/>
<br>
<div>
    <div id="buttons" class="inline">
        <form action="${pageContext.request.contextPath}/server/" method="post" id="sendToServer">
            <div class="X-button-group">
                <jsp:include page="XButtons.html"/>
            </div>
            <br>
            <div class="Y-button-group">
                <jsp:include page="YButtons.html"/>
            </div>
            <br>
            <div class="R-button-group">
                <jsp:include page="RButtons.html"/>
            </div>
            <br>
            <div class="buttonResult">
                <button class="button" type="submit">
                    Проверить
                </button>
            </div>
            <br>
            <div>
                <div id="errorMessage"></div>
            </div>
        </form>
    </div>
    <br>
    <div id="plot" class="inline">
        <canvas id="canvas" width="350" height="350"></canvas>
    </div>
</div>
<script src="validation_script.js"></script>
<script src="draw.js"></script>
</body>
</html>