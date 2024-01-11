package lesson6.classwork.bus;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Bus {
    private final String BUS_TIMES_ADDRESS = "src/lesson6/classwork/bus/data/bus_times.txt";
    private HashMap<Integer, List<Integer>> busTimes = new HashMap<>();

    public Bus() throws IOException {
        populateBusTimes();
    }

    private void populateBusTimes() throws IOException {
        List<String> lines = readFile();
        for (String line : lines) {
            line = line.replaceAll("[\t ]+", " ");
            List<String> times = Arrays.stream(line.split(" ")).toList();
            List<Integer> minutes = times.subList(1, times.size()).stream().map(Integer::parseInt).toList();
            busTimes.put(Integer.parseInt(times.getFirst()), minutes);
        }
    }

    private List<String> readFile() throws IOException {
        Path path = Path.of(BUS_TIMES_ADDRESS);
        BufferedReader reader = Files.newBufferedReader(path);
        return reader.lines().toList();
    }


    public String getDepartureTime(String time) throws IncorrectTimeException {
        if (!time.matches("^(?:\\d|[01]\\d|2[0-3])[.:][0-5]\\d$")) {
            throw new IncorrectTimeException(time);
        }
        int hour = Integer.parseInt(time.substring(0, 2));
        int minute = Integer.parseInt(time.substring(3));

        for (Integer departureHour : busTimes.keySet()) {
            if (departureHour == hour) {
                for (int departureMinute : busTimes.get(departureHour)) {
                    if (departureMinute > minute) {
                        return timeToString(departureHour, departureMinute);
                    }
                }
            } else if (departureHour > hour) {
                return timeToString(departureHour, busTimes.get(departureHour).getFirst());
            }
        }

        return null;
    }

    private String timeToString(int hour, int minute) {
        String hourString = String.format("%s%d", hour < 10 ? "0" : "", hour);
        String minuteString = String.format("%s%d", minute < 10 ? "0" : "", minute);
        return String.format("%s:%s", hourString, minuteString);
    }
}
