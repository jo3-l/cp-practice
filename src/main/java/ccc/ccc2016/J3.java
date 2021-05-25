package ccc.ccc2016;

import java.util.Scanner;

public class J3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        int longestLen = 0;
        for (int i = 0; i < input.length() - 1; i++) {
            for (int j = input.length(); j > i; j--) {
                String substr = input.substring(i, j);
                if (isPalindrome(substr) && substr.length() > longestLen) longestLen = substr.length();
            }
        }
        System.out.println(longestLen);
    }

    private static boolean isPalindrome(String word) {
        int len = word.length();
        if (len == 1) return true;

        int mid = Math.floorDiv(len, 2);
        for (int i = 0; i <= mid; i++) {
            if (word.charAt(i) != word.charAt(len - i - 1)) return false;
        }
        return true;
    }
}
