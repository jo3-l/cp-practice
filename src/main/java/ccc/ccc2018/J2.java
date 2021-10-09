package ccc.ccc2018;

import java.util.Scanner;

public class J2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int parkingSpaces = scanner.nextInt();

        scanner.skip("\n");
        String yesterdayInfo = scanner.nextLine();
        String todayInfo = scanner.nextLine();

        int count = 0;
        for (int i = 0; i < parkingSpaces; i++) {
            if (yesterdayInfo.charAt(i) == 'C' && todayInfo.charAt(i) == 'C') ++count;
        }

        System.out.println(count);
    }
}
