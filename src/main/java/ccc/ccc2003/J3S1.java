package ccc.ccc2003;

import java.util.Scanner;

public class J3S1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] from = {99, 90, 54, 67, 40, 9};
        int[] to = {77, 48, 19, 86, 64, 34};
        int c = 1;
        int s;
        for (s = sc.nextInt(); s != 0; s = sc.nextInt()) {
            if (c + s <= 100) c += s;
            for (int i = 0; i < 6; i++) {
                if (from[i] == c) {
                    c = to[i];
                    break;
                }
            }
            System.out.println("You are now on square " + c);
            if (c == 100) {
                System.out.println("You Win!");
                break;
            }
        }

        if (s == 0) System.out.println("You Quit!");
    }
}
