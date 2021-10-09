package kattis;

import java.util.Scanner;

public class ThreeDPrinter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int statueNumber = scanner.nextInt();
        System.out.println(Math.round(Math.ceil(Math.log(statueNumber) / Math.log(2)) + 1));
    }
}
