package ccc_2017;

import java.util.Scanner;

public class J1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();

        if (x > 0) {
            // x > 0, y > 0 -> 1st quadrant
            if (y > 0) System.out.println("1");
                // x > 0, y < 0 -> 4th quadrant
            else System.out.println("4");
        } else {
            // x < 0, y > 0 -> 2nd quadrant
            if (y > 0) System.out.println("2");
                // x < 0, y < 0 -> 3rd quadrant
            else System.out.println("3");
        }
    }
}
