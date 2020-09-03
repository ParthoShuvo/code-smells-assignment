package applicationlevel.refactoring;

public class DistanceCalculator {
    public double betweenPoints(Point p1, Point p2) {
        return Math.sqrt(Math.pow((p2.getY() - p1.getY()), 2) + Math.pow(p2.getX() - p1.getX(), 2));
    }

    public double toOriginFrom(Point p) {
        return Math.sqrt(Math.pow(p.getX(), 2) + Math.pow(p.getY(), 2));
    }
}
