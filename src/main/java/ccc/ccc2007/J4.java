package ccc.ccc2007;

import java.util.Scanner;

public class J4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s0 = sc.nextLine();
        String s1 = sc.nextLine();
        int[] f0 = f(s0);
        int[] f1 = f(s1);
        int i;
        for (i = 0; i < 26; i++) if (f0[i] != f1[i]) break;
        System.out.println(i == 26 ? "Is an anagram." : "Is not an anagram.");
    }

    private static int[] f(String x) {
        int[] ff = new int[26];
        for (int i = 0; i < x.length(); i++) {
            char c = x.charAt(i);
            if (c != ' ') ff[c - 'A']++;
        }
        return ff;
    }
}
