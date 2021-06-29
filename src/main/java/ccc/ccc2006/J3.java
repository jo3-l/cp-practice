package ccc.ccc2006;

import java.util.Scanner;

public class J3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (String s = sc.nextLine(); !s.equals("halt"); s = sc.nextLine()) {
            int i = 0;
            int t = 0;
            while (i < s.length()) {
                char c = s.charAt(i++);
                t += press(c);
                while (i < s.length() && cat(s.charAt(i)) == cat(c)) {
                    t += 2 /* pause */ + press(s.charAt(i++));
                }
            }

            System.out.println(t);
        }
    }

    private static int press(char c) {
        if (c <= 'c') return c - 'a' + 1;
        if (c <= 'f') return c - 'd' + 1;
        if (c <= 'i') return c - 'g' + 1;
        if (c <= 'l') return c - 'j' + 1;
        if (c <= 'o') return c - 'm' + 1;
        if (c <= 's') return c - 'p' + 1;
        if (c <= 'v') return c - 't' + 1;
        return c - 'w' + 1;
    }

    private static int cat(char c) {
        if (c <= 'c') return 0;
        if (c <= 'f') return 1;
        if (c <= 'i') return 2;
        if (c <= 'l') return 3;
        if (c <= 'o') return 4;
        if (c <= 's') return 5;
        if (c <= 'v') return 6;
        return 7;
    }
}
