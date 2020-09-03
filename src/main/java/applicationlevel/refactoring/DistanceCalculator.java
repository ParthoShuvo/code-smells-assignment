package applicationlevel.refactoring;

public class DistanceCalculator {
    public double betweenPoints(Point p1, Point p2) {
        return Math.sqrt(Math.pow((p2.getY() - p1.getY()), 2) + Math.pow(p2.getX() - p1.getX(), 2));
    }

    public double toOriginFrom(Point p) {
        Point origin = new Point(0, 0);
        return betweenPoints(origin, p);
    }
}
