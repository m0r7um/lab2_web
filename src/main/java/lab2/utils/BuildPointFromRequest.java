package lab2.utils;

import jakarta.servlet.http.HttpServletRequest;
import lab2.models.Point;

import java.util.HashMap;
import java.util.Map;

public class BuildPointFromRequest {
    public static Point build(HttpServletRequest request) {
        Point point;
        Map<String, String> attributes = readAttributes(request);
        point = new Point(Integer.parseInt(attributes.get("x")),
                          Double.parseDouble(attributes.get("y")),
                          Double.parseDouble(attributes.get("r")),
                  false);
        return point;
    }
    //🙏🙏🙏
    private static Map<String, String> readAttributes(HttpServletRequest request) {
        Map<String, String> attributes = new HashMap<>();
        attributes.put("x", request.getParameter("x"));
        attributes.put("y", request.getParameter("y"));
        attributes.put("r", request.getParameter("r"));
        return attributes;
    }
}
