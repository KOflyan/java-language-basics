package homework.EX01A;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;


class EX01ATest {
    private final static PrintStream DEFAULT_OUTPUT_STREAM = System.out;
    private OutputStream outputStreamOverride;

    @BeforeEach
    void setUp() {
        this.outputStreamOverride = new ByteArrayOutputStream();
        PrintStream printStreamOverride = new PrintStream(this.outputStreamOverride);

        System.setOut(printStreamOverride);
    }

    @AfterEach
    void tearDown() {
        System.setOut(DEFAULT_OUTPUT_STREAM);
    }


    @Test
    void getHello() {
        EX01A.getHello();

        assertEquals(
                "Hello world!",
                this.outputStreamOverride.toString().trim()
        );
    }
}