package ccc.ccc2013;

import java.util.Scanner;

public class J2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (!canUseLetter(c)) {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
    }

    private static boolean canUseLetter(char c) {
        switch (c) {
            case 'I':
            case 'O':
            case 'S':
            case 'H':
            case 'Z':
            case 'X':
            case 'N':
                return true;
            default:
                return false;
        }
    }
}
