package applicationlevel.refactoring;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DistanceCalculatorTest {

    private DistanceCalculator distanceCalculator;

    @BeforeEach
    void setUp() {
        distanceCalculator = new DistanceCalculator();
    }

    @Test
    void betweenPoints() {
        Point p1 = new Point(1, 5);
        Point p2 = new Point(2, 8);
        double distance = distanceCalculator.betweenPoints(p1, p2);

        assertEquals(3.16, distance, 0.01);
    }

    @Test
    void toOriginFrom() {
        Point p = new Point(1, 5);
        double distance = distanceCalculator.toOriginFrom(p);

        assertEquals(5.1, distance, 0.01);
    }
}