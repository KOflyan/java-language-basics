package homework.EX01B;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.DoubleStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EX01BTest {

    @Test
    void testComputeTriangleArea() {
        List<Double> triangleDimensions = generateRandomNumbers();

        for (int i = 0; i < triangleDimensions.size() - 1; i++) {
            double height = triangleDimensions.get(i);
            double base = triangleDimensions.get(i + 1);

            double actualResult = EX01B.computeTriangleArea(height, base);

            assertEquals((base * height) / 2, actualResult);
        }
    }

    @Test
    void testComputeCircleArea() {
        List<Double> circleRadiuses = generateRandomNumbers();

        circleRadiuses.forEach(radius -> {
            double actualResult = EX01B.computeCircleArea(radius);
            double expectedResult = Math.PI * Math.pow(radius, 2);

            assertEquals(expectedResult, actualResult);
        });
    }

    @Test
    void testComputeRectangleArea() {
        var rectangleDimensions = generateRandomNumbers();

        for (int i = 0; i < rectangleDimensions.size() - 1; i++) {
            double width = rectangleDimensions.get(i);
            double height = rectangleDimensions.get(i + 1);

            double actualResult = EX01B.computeRectangleArea(width, height);

            assertEquals(width * height, actualResult);
        }

    }

    private List<Double> generateRandomNumbers() {
        Random random = new Random();

        return new ArrayList<>(DoubleStream.generate(() -> random.nextFloat() * 200)
                .limit(100)
                .boxed()
                .toList()
        );
    }
}
