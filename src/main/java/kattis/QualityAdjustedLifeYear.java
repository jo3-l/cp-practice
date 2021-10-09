package kattis;

import java.util.Scanner;

public class QualityAdjustedLifeYear {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int periods = scanner.nextInt();

        float totalQal = 0;
        for (int i = 0; i < periods; i++) {
            float quality = scanner.nextFloat();
            float years = scanner.nextFloat();
            totalQal += quality * years;
        }

        System.out.println(totalQal);
    }
}
