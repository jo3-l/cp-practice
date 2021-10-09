package ccc.ccc2011;

import java.util.Scanner;

public class J2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int humidity = scanner.nextInt();
        int maxHours = scanner.nextInt();

        for (int hour = 1; hour <= maxHours + 1; hour++) {
            int altitude = (-6 * (int) Math.pow(hour, 4))
                    + (humidity * (int) Math.pow(hour, 3))
                    + (2 * (int) Math.pow(hour, 2))
                    + hour;
            if (altitude <= 0) {
                System.out.println("The balloon first touches ground at hour:");
                System.out.println(hour);
                return;
            }
        }
        System.out.println("The balloon does not touch ground in the given time.");
    }
}
