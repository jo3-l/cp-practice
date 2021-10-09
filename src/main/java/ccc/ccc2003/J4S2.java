package ccc.ccc2003;

import java.util.Scanner;

public class J4S2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        sc.skip("\n");
        while (v-- > 0) {
            String[] rhymes = new String[4];
            for (int i = 0; i < 4; i++) {
                String s = sc.nextLine().toLowerCase();
                int j = s.length() - 1;
                while (j >= 0) {
                    if (isVowel(s.charAt(j))) break;
                    if (s.charAt(j) == ' ') {
                        j++;
                        break;
                    }
                    j--;
                }
                rhymes[i] = s.substring(Math.max(0, j));
            }
            if (doesRhyme(rhymes[0], rhymes[1], rhymes[2], rhymes[3])) System.out.println("perfect");
            else if (doesRhyme(rhymes[0], rhymes[1]) && doesRhyme(rhymes[2], rhymes[3])) System.out.println("even");
            else if (doesRhyme(rhymes[0], rhymes[2]) && doesRhyme(rhymes[1], rhymes[3])) System.out.println("cross");
            else if (doesRhyme(rhymes[0], rhymes[3]) && doesRhyme(rhymes[1], rhymes[2])) System.out.println("shell");
            else System.out.println("free");
        }
    }

    private static boolean doesRhyme(String... xs) {
        String x = xs[0];
        for (int i = 1; i < xs.length; i++) {
            if (!xs[i].equals(x)) return false;
        }
        return true;
    }

    private static boolean isVowel(char c) {
        switch (c) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
                return true;
            default:
                return false;
        }
    }
}
