package ccc.ccc2005;

import java.util.Scanner;

public class S2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = 0;
        int y = 0;
        int c = sc.nextInt();
        int r = sc.nextInt();
        for (int ox = sc.nextInt(), oy = sc.nextInt(); ox != 0 || oy != 0; ox = sc.nextInt(), oy = sc.nextInt()) {
            x += ox;
            y += oy;
            if (x > c) x = c;
            if (y > r) y = r;
            if (x < 0) x = 0;
            if (y < 0) y = 0;
            System.out.println(x + " " + y);
        }
    }
}
