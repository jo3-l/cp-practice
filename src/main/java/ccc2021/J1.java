package ccc2021;

import java.util.Scanner;

public class J1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int boilingPoint = scanner.nextInt();

        int pressure = 5 * boilingPoint - 400;
        System.out.println(pressure);

        if (pressure < 100) System.out.println(1);
        else if (pressure == 100) System.out.println(0);
        else System.out.println(-1);
    }
}
