<%@ page import="lab2.models.Points" %>
<%@ page import="lab2.models.Point" %>
<%@ page import="java.util.List" %>
<%@ page import="lab2.utils.AddToSession" %>
<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">

    <meta name="author" content="Вальц Мартин Эдуардович">
    <meta name="description" content="Веб-программирование: Лабораторная работа №2">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link rel="stylesheet" href="stylesheets/styles.css"/>
    <title>Лабораторная работа №2 | Веб-программирование</title>
</head>

<body>
<jsp:include page="header.html"/>
<br>
<div>
    <div id="buttons" class="inline">
        <div id="generateBlock">
            <%
                Points allPoints = (Points) request.getSession().getAttribute(AddToSession.POINTS_ATTRIBUTE_NAME);
                Point newPoint = (Point) request.getAttribute("point");
                if (allPoints == null || allPoints.getPoints() == null || newPoint == null || allPoints.getPointsByR(newPoint.getR()) == null) {
            %>
            <h4>
                <span class="outputStub notification">Нет результатов</span>
                <span class="outputStub notification"><%= allPoints %></span>
                <span class="outputStub notification"><%= newPoint %></span>
            </h4>
            <% } else { %>
            <table id='generateTable'>
                <tr>
                    <th>X</th>
                    <th>Y</th>
                    <th>R</th>
                    <th>Точка входит в ОДЗ</th>
                </tr>
                <%
                    List<Point> points = allPoints.getPointsByR(newPoint.getR());
                    for (int i = points.size() - 1; i >= 0; i--) {
                        Point point = points.get(i);
                %>
                <tr>
                    <td><%= point.getX() %></td>
                    <td><%= point.getY() %></td>
                    <td><%= point.getR() %></td>
                    <td>
                        <%= point.getIsInArea() ? "<span class=\"success\">Попал</span>" : "<span class=\"fail\">Промазал</span>" %>
                    </td>
                </tr>
                <% } %>
            </table>
            <% } %>
        </div>
    </div>
    <br>
    <div id="plot" class="inline">
        <canvas id="canvas" width="350" height="350"></canvas>
    </div>
    <div id="goBack">
        <a href="${pageContext.request.contextPath}/index.jsp">Вернуться к форме</a>
    </div>
</div>
<script>
    window.onload = () => {
        <%  if (allPoints != null && allPoints.getPoints() != null && newPoint != null && allPoints.getPointsByR(newPoint.getR()) != null) {
                List<Point> points = allPoints.getPointsByR(newPoint.getR());
                for (Point point : points) { %>
        drawPoint(<%= point.getX() %>, <%= point.getY() %>, <%= point.getR() %>);
        <% } %>
        <% } %>
    }
</script>
<script src="${pageContext.request.contextPath}/validation_script.js"></script>
<script src="${pageContext.request.contextPath}/draw.js"></script>
</body>
</html>
