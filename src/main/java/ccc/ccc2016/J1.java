package ccc.ccc2016;

import java.util.Scanner;

public class J1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int wins = 0;
        for (int i = 0; i < 6; i++) {
            if (scanner.nextLine().charAt(0) == 'W') ++wins;
        }

        if (wins == 0) System.out.println("-1");
        else if (wins <= 2) System.out.println("3");
        else if (wins <= 4) System.out.println("2");
        else System.out.println("1");
    }
}
