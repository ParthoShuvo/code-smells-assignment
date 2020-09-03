package applicationlevel.duplicatecode;

public class DistanceCalculator {
    public double betweenPoints(int x1, int y1, int x2, int y2) { // can be reused from toOriginFrom
        return Math.sqrt(Math.pow((y2 - y1), 2) + Math.pow(x2 - x1, 2));
    }

    public double toOriginFrom(int x, int y) { // Data clump detected, can be extracted to class
        return Math.sqrt(Math.pow(y, 2) + Math.pow(x, 2)); // Duplicate code
    }
}
