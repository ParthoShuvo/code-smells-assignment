package applicationlevel.duplicatecode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DistanceCalculatorTest {

    private DistanceCalculator distanceCalculator;

    @BeforeEach
    public void setUp() throws Exception {
        distanceCalculator = new DistanceCalculator();
    }

    @Test
    void betweenPoints() {
        double distance = distanceCalculator.betweenPoints(1, 5, 2, 8);

        assertEquals(3.16, distance, 0.01);
    }

    @Test
    void toOriginFrom() {
        double distance = distanceCalculator.toOriginFrom(1, 5);

        assertEquals(5.1, distance, 0.01);
    }
}