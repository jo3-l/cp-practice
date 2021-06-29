package ccc.ccc2006;

import java.util.Scanner;

public class J1 {
    private static final int[][] menus = {
            {0, 461, 431, 420, 0},
            {0, 100, 57, 70, 0},
            {0, 130, 160, 118, 0},
            {0, 167, 266, 75, 0},
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int c = 0;
        for (int[] menu : menus) c += menu[sc.nextInt()];
        System.out.println("Your total Calorie count is " + c + ".");
    }
}
