package ccc.ccc2002;

import java.util.Scanner;

public class J2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (String s = sc.nextLine(); !s.equals("quit!"); s = sc.nextLine()) {
            if (s.length() > 4 && s.endsWith("or") && !isVowel(s.charAt(s.length() - 3))) {
                s = s.substring(0, s.length() - 2) + "our";
            }
            System.out.println(s);
        }
    }

    private static boolean isVowel(char c) {
        switch (c) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
            case 'y':
                return true;
            default:
                return false;
        }
    }
}
