package ccc_2016;

import java.time.LocalTime;
import java.util.Scanner;

public class J4 {
    private static final LocalTime MORNING_TRAFFIC_START = LocalTime.of(7, 0);
    private static final LocalTime MORNING_TRAFFIC_END = LocalTime.of(10, 0);
    private static final LocalTime AFTERNOON_TRAFFIC_START = LocalTime.of(15, 0);
    private static final LocalTime AFTERNOON_TRAFFIC_END = LocalTime.of(19, 0);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LocalTime time = LocalTime.parse(scanner.nextLine());

        int remainingDistance = 240;
        while (remainingDistance > 0) {
            time = time.plusMinutes(1);
            boolean isInTraffic = time.isAfter(MORNING_TRAFFIC_START) && time.isBefore(MORNING_TRAFFIC_END)
                    || time.isAfter(AFTERNOON_TRAFFIC_START) && time.isBefore(AFTERNOON_TRAFFIC_END);
            remainingDistance -= isInTraffic ? 1 : 2;
        }

        System.out.println(time.toString());
    }
}
