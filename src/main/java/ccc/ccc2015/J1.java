package ccc.ccc2015;

import java.time.Month;
import java.time.MonthDay;
import java.util.Scanner;

public class J1 {
    private static final MonthDay FEBRUARY_18 = MonthDay.of(Month.FEBRUARY, 18);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int month = scanner.nextInt();
        int day = scanner.nextInt();
        MonthDay date = MonthDay.of(month, day);

        if (date.isAfter(FEBRUARY_18)) System.out.println("After");
        else if (date.equals(FEBRUARY_18)) System.out.println("Special");
        else System.out.println("Before");
    }
}
