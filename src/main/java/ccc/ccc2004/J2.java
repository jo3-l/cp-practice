package ccc.ccc2004;

import java.util.Scanner;

public class J2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int b = sc.nextInt();
        int f = sc.nextInt();
        System.out.println("All positions change in year " + b);
        int ms = (f - b) / 60;
        for (int i = 0; i < ms; i++) System.out.println("All positions change in year " + (b += 60));
    }
}
