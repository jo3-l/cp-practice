package ccc2016;

import java.util.Arrays;
import java.util.Scanner;

public class J5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean asksForMinimum = scanner.nextInt() == 1;
        int citizenCount = scanner.nextInt();

        Integer[] dmojistanCitizens = new Integer[citizenCount];
        for (int i = 0; i < citizenCount; i++) dmojistanCitizens[i] = scanner.nextInt();

        Integer[] peglandCitizens = new Integer[citizenCount];
        for (int i = 0; i < citizenCount; i++) peglandCitizens[i] = scanner.nextInt();

        Arrays.sort(dmojistanCitizens);
        Arrays.sort(peglandCitizens);
        if (asksForMinimum) {
            int total = 0;
            for (int i = 0; i < citizenCount; i++) total += Math.max(dmojistanCitizens[i], peglandCitizens[i]);

            System.out.println(total);
            return;
        }

        int total = 0;
        for (int i = 0; i < citizenCount; i++) {
            total += Math.max(dmojistanCitizens[i], peglandCitizens[citizenCount - i - 1]);
        }
        System.out.println(total);
    }
}
