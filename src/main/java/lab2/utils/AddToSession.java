package lab2.utils;

import jakarta.servlet.http.HttpServletRequest;
import lab2.models.Point;
import lab2.models.Points;

public class AddToSession {
    public static final String POINTS_ATTRIBUTE_NAME= "points";

    public static void add(HttpServletRequest request) {
        var point = (Point) request.getAttribute("point");
        point.setIsInArea(CheckArea.check(point));
        Points points = (Points) request.getSession().getAttribute(POINTS_ATTRIBUTE_NAME);
        if (points == null) {
            points = new Points();
            request.getSession().setAttribute(POINTS_ATTRIBUTE_NAME, points);
       }
        points.addPoint(point);
    }
}
