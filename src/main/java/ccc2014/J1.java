package ccc2014;

import java.util.Scanner;

public class J1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int angle1 = scanner.nextInt();
        int angle2 = scanner.nextInt();
        int angle3 = scanner.nextInt();

        if (angle1 + angle2 + angle3 != 180) {
            System.out.println("Error");
            return;
        }

        if (angle1 == angle2 || angle1 == angle3 || angle2 == angle3) {
            if (angle1 == 60) System.out.println("Equilateral");
            else System.out.println("Isosceles");
        } else {
            System.out.println("Scalene");
        }
    }
}
