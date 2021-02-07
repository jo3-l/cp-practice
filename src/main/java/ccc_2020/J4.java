package ccc_2020;

import java.util.Scanner;

public class J4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        String str = scanner.nextLine();

        for (int i = 0; i < str.length(); i++) {
            // Pretty self explanatory, you shift the string _i_ characters and that's the cyclic shift.
            String cyclicShift = str.substring(i) + str.substring(0, i);
            if (text.contains(cyclicShift)) {
                System.out.println("yes");
                return;
            }
        }
        System.out.println("no");
    }
}
