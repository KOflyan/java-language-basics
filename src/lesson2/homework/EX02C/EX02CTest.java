package lesson2.homework.EX02C;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class EX02CTest {

    private static final List<TestDataContainer> GET_CELL_INDEX_TEST_DATA = new ArrayList<>(
            Arrays.asList(
                    new TestDataContainer(new int[]{ 0, 0, 10 }, 0),
                    new TestDataContainer(new int[]{ 0, 0, 1 }, 0),
                    new TestDataContainer(new int[]{ 0, 1, 10 }, 1),
                    new TestDataContainer(new int[]{ 1, 0, 10 }, 10),
                    new TestDataContainer(new int[]{ 1, 0, 2 }, 2),
                    new TestDataContainer(new int[]{ 5, 0, 1 }, 5),
                    new TestDataContainer(new int[]{ 5, 11, 12 }, 71),
                    new TestDataContainer(new int[]{ 114, 56, 19 }, -1),
                    new TestDataContainer(new int[]{ 9984, 1546, 71 }, -1),
                    new TestDataContainer(new int[]{ 9984, 1546, 1699 }, 16964362),
                    new TestDataContainer(new int[]{ 114, 56, 191 }, 21830)
            )
    );


    private static final List<TestDataContainer> GET_ROW_COL_INDEX_TEST_DATA = new ArrayList<>(
            Arrays.asList(
                    new TestDataContainer(new int[]{ 0, 10 }, new int[]{ 0, 0 }),
                    new TestDataContainer(new int[]{ 0, 1 }, new int[]{ 0, 0 }),
                    new TestDataContainer(new int[]{ 12, 1 }, new int[]{ 12, 0 }),
                    new TestDataContainer(new int[]{ 123, 124 }, new int[]{ 0, 123 }),
                    new TestDataContainer(new int[]{ 1223, 23 }, new int[]{ 53, 4 }),
                    new TestDataContainer(new int[]{ 7888712, 11 }, new int[]{ 717155, 7 })
                )
    );


    private static final List<TestDataContainer> GET_ROW_LENGTH_TEST_DATA = new ArrayList<>(
            Arrays.asList(
                    new TestDataContainer(new int[]{ 1, 0, 2 }, 2),
                    new TestDataContainer(new int[]{ 0, 0, 2 }, -1),
                    new TestDataContainer(new int[]{ 0, 0, 0 }, -1),
                    new TestDataContainer(new int[]{ 1, 3, 5 }, -1),
                    new TestDataContainer(new int[]{ 12, 0, 12 }, 1),
                    new TestDataContainer(new int[]{ 6, 7, 55 }, 8),
                    new TestDataContainer(new int[]{ 6, 7, 48 }, -1),
                    new TestDataContainer(new int[]{ 16, 6, 182 }, 11),
                    new TestDataContainer(new int[]{ 199, 79, 23760 }, 119)
            )
    );

    static class TestDataContainer {
        int[] input;
        int[] output;

        public TestDataContainer(int[] input, int[] output) {
            this.input = input;
            this.output = output;
        }

        public TestDataContainer(int[] input, int output) {
            this.input = input;
            this.output = new int[] { output };
        }
    }


    @Test
    void testGetCellIndex() {
        EX02CTest.GET_CELL_INDEX_TEST_DATA.forEach(data ->
            assertEquals(EX02C.getCellIndex(data.input[0], data.input[1], data.input[2]), data.output[0])
        );
    }

    @Test
    void testGetRowIndex() {
        EX02CTest.GET_ROW_COL_INDEX_TEST_DATA.forEach(data -> assertEquals(EX02C.getRowIndex(data.input[0], data.input[1]), data.output[0], String.format("Input: %s", Arrays.toString(data.input))));
    }

    @Test
    void testGetColIndex() {
        EX02CTest.GET_ROW_COL_INDEX_TEST_DATA.forEach(data -> assertEquals(EX02C.getColIndex(data.input[0], data.input[1]), data.output[1], String.format("Input: %s", Arrays.toString(data.input))));
    }

    @Test
    void testGetRowLength() {
        EX02CTest.GET_ROW_LENGTH_TEST_DATA.forEach(data -> assertEquals(EX02C.getRowLength(data.input[0], data.input[1], data.input[2]), data.output[0], String.format("Input: %s", Arrays.toString(data.input))));
    }
}
