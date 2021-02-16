package ccc2020;

import java.util.Scanner;

public class J2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int targetTotalInfections = scanner.nextInt();
        int initialInfections = scanner.nextInt();
        int reproductionNumber = scanner.nextInt();

        // Note: There should be clever math way of doing this using the geometric series formula, but I wasn't able to find
        // it and was too lazy to look further since the current solution gets full points on the CCC online grader and
        // DMOJ.
        int totalInfections = initialInfections;
        int day = 0;
        while (totalInfections <= targetTotalInfections) {
            ++day;
            totalInfections += (int) Math.pow(reproductionNumber, day) * initialInfections;
        }

        System.out.println(day);
    }
}
