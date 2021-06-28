package ccc.ccc2008;

import java.util.Scanner;

public class J3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int x = 0;
        int y = 0;
        int n = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int wantX = specialX(c);
            int wantY = wantX == -1 ? -1 : 4;
            if (wantX == -1) {
                wantY = (c - 'A') / 6;
                wantX = (c - 'A') % 6;
            }
            n += Math.abs(x - wantX) + Math.abs(y - wantY);
            x = wantX;
            y = wantY;
        }
        System.out.println(n + Math.abs(x - 5) + Math.abs(y - 4));
    }

    private static int specialX(char c) {
        if (c == 'Y' || c == 'Z') return c - 'Y';
        if (c == ' ') return 2;
        if (c == '-') return 3;
        if (c == '.') return 4;
        return -1;
    }
}
