package applicationlevel.refactoring;

public class DistanceCalculator {
    public double betweenPoints(Point p1, Point p2) {
        return Math.sqrt(square(p2.getY() - p1.getY()) + square(p2.getX() - p1.getX()));
    }

    private double square(int val) {
        return val * val;
    }

    public double toOriginFrom(Point p) {
        Point origin = new Point(0, 0);
        return betweenPoints(origin, p);
    }
}
