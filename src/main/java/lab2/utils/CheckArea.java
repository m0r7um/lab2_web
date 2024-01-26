package lab2.utils;

import lab2.models.Point;

public class CheckArea {
    public static boolean check(Point point) {
        double x = point.getX();
        double y = point.getY();
        double r = point.getR();
        if (x >= 0 && y >= 0) {
            return (y <= -x + r / 2);
        }
        if (x < 0 && y >= 0) {
            return (x * x + y * y) <= (r * r);
        }
        // Top-left quadrant
        // Bottom-left quadrant
        if (x <= 0 && y < 0) {
            return (x >= -r / 2) && (y >= -r);
        }

        // Bottom-right quadrant😍😍😍
        return false;
    }
}
