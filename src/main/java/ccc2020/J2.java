package ccc2020;

import java.util.Scanner;

public class J2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int targetTotalInfections = scanner.nextInt();
        int initialInfections = scanner.nextInt();
        int reproductionNumber = scanner.nextInt();

        int totalInfections = initialInfections;
        int day = 0;
        while (totalInfections <= targetTotalInfections) {
            ++day;
            totalInfections += (int) Math.pow(reproductionNumber, day) * initialInfections;
        }

        System.out.println(day);
    }
}
