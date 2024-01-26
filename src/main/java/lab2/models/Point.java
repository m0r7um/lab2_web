package lab2.models;

public class Point {
    double x;
    double y;
    double r;
    boolean isInArea;

    public Point(int x, double y, double r, boolean isInArea){
        this.x = x;
        this.y = y;
        this.r = r;
        this.isInArea = isInArea;
    }

    public void setIsInArea(boolean isInArea) {
        this.isInArea = isInArea;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getR() {
        return r;
    }

    public boolean getIsInArea() {
        return isInArea;
    }
}
