package ccc.ccc2017;

import java.util.Scanner;

public class J2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int shiftCount = scanner.nextInt();
        int sum = (int) (1 - Math.pow(10, shiftCount + 1)) / -9;
        System.out.println(sum * num);
    }
}
