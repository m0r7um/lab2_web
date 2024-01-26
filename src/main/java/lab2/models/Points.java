package lab2.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Points implements Serializable {
    private final List<Point> points = Collections.synchronizedList(new ArrayList<>());

    public void addPoint(Point point) {
        points.add(point);
    }

    public List<Point> getPoints() {
        return points;
    }

    public List<Point> getPointsByR(double r) {
        return points.stream().filter(x -> x.getR() == r).collect(Collectors.toList());
    }
}
