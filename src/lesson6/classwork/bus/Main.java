package lesson6.classwork.bus;

import lesson6.classwork.bus.Bus;
import lesson6.classwork.bus.IncorrectTimeException;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IncorrectTimeException, IOException {
        Bus bus = new Bus();
        System.out.println(bus.getDepartureTime("10:00"));
        System.out.println(bus.getDepartureTime("23.27"));
        System.out.println(bus.getDepartureTime("00:00"));
        System.out.println(bus.getDepartureTime("24:00"));
    }
}
