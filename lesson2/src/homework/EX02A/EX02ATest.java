package homework.EX02A;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.DoubleStream;

public class EX02ATest {

    @Test
    void testCompare() {
        int range = 100;
        int limit = 1_000;

        Random random = new Random();

        List<Double> numbers = new ArrayList<>(DoubleStream.generate(() -> random.nextFloat() * range)
                .limit(limit)
                .boxed()
                .toList()
        );

        numbers.addAll(
                Collections.nCopies(15, 5.0).stream().toList()
        );

        for (double number: numbers) {
            Assertions.assertEquals(
                    EX02A.compare(number),
                    number > 5
                            ? "The input number is bigger than 5!"
                            : number < 5
                                ? "The input number is smaller than 5!"
                                : "The input number is 5!"
            );
        }
    }
}