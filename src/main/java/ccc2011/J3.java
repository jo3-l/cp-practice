package ccc2011;

import java.util.Scanner;

public class J3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int initialValue = scanner.nextInt();
        int secondLastTerm = scanner.nextInt();
        int lastTerm = initialValue - secondLastTerm;

        int length = 3;
        while (lastTerm <= secondLastTerm) {
            int currentTerm = secondLastTerm - lastTerm;
            secondLastTerm = lastTerm;
            lastTerm = currentTerm;
            ++length;
        }

        System.out.println(length);
    }
}
