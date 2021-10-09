package ccc.ccc2012;

import java.util.Scanner;

public class S2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int lastv = Integer.MIN_VALUE;
        int v = 0;
        for (int i = s.length() - 1; i >= 1; i -= 2) {
            int arv = getv(s.charAt(i));
            int dec = s.charAt(i - 1) - '0';
            if (i == s.length() - 1 || arv >= lastv) {
                v += arv * dec;
            } else {
                v -= arv * dec;
            }
            lastv = arv;
        }
        System.out.println(v);
    }

    private static int getv(char x) {
        switch (x) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            default:
                return 1000;
        }
    }
}
