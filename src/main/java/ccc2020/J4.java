package ccc2020;

import java.util.Scanner;

public class J4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        String toShift = scanner.nextLine();

        for (int i = 0; i < toShift.length(); i++) {
            String cyclicShift = toShift.substring(i) + toShift.substring(0, i);
            if (text.contains(cyclicShift)) {
                System.out.println("yes");
                return;
            }
        }
        System.out.println("no");
    }
}
