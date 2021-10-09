package ccc.ccc2005;

import java.util.Scanner;

public class J5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String cur = sc.nextLine();
        while (!cur.equals("X")) {
            System.out.println(isMonkeyWord(cur) ? "YES" : "NO");
            cur = sc.nextLine();
        }
    }

    // Word  ::= AWord [ 'N' Word ]
    // AWord ::= 'A' | 'B' Word 'S'
    // =>
    // Word ::= ('A' | 'B' Word 'S') [ 'N' Word ]
    private static boolean isMonkeyWord(String s) {
        if (s.isEmpty()) return true;
        char c = s.charAt(0);
        if (c == 'A') {
            return s.length() == 1 || (s.charAt(1) == 'N' && isMonkeyWord(s.substring(2)));
        }
        if (c == 'B') {
            for (int i = 2; i < s.length(); i++) {
                if (s.charAt(i) == 'S') {
                    if (!isMonkeyWord(s.substring(1, i))) continue;
                    if (i == s.length() - 1) return true;
                    char after = s.charAt(i + 1);
                    if (after != 'N') continue;
                    if (i == s.length() - 2) return false;
                    if (isMonkeyWord(s.substring(i + 2))) return true;
                }
            }
            return false;
        }
        return false;
    }
}
