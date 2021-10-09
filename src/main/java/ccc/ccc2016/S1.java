package ccc.ccc2016;

import java.util.Scanner;

public class S1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s0 = sc.nextLine();
        String s1 = sc.nextLine();
        if (s0.length() != s1.length()) {
            System.out.println("N");
        } else {
            int[] f0 = new int[26];
            for (int i = 0; i < s0.length(); i++) f0[s0.charAt(i) - 'a']++;
            int[] f1 = new int[26];
            int wildcard = 0;
            for (int i = 0; i < s1.length(); i++) {
                char c = s1.charAt(i);
                if (c == '*') wildcard++;
                else f1[c - 'a']++;
            }

            int i;
            for (i = 0; i < 26; i++) {
                int diff = f1[i] - f0[i];
                if (diff > 0) {
                    System.out.println("N");
                    break;
                }
                if (diff != 0) {
                    wildcard -= diff;
                    if (wildcard < 0) {
                        System.out.println("A");
                        break;
                    }
                }
            }
            if (i == 26) System.out.println("A");
        }
    }
}
