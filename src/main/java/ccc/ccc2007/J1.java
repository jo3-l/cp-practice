package ccc.ccc2007;

import java.util.Scanner;

public class J1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int max = Math.max(Math.max(a, b), c);
        int min = Math.min(Math.min(a, b), c);
        System.out.println(a + b + c - max - min);
    }
}
