package ccc_2018;

import java.util.Scanner;

public class J1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int first = scanner.nextInt();
        int second = scanner.nextInt();
        int third = scanner.nextInt();
        int fourth = scanner.nextInt();

        if ((first == 8 || first == 9) && second == third && (fourth == 8 || fourth == 9)) System.out.println("ignore");
        else System.out.println("answer");
    }
}
