package ccc.ccc2003;

import java.util.Scanner;

public class J1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int s = sc.nextInt();
        int h = sc.nextInt();
        int rh = t + h + 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rh; i++) {
            if (i > 0) sb.append('\n');
            if (i < t) {
                // still on tines
                sb.append('*');
                for (int j = 0; j < s; j++) sb.append(' ');
                sb.append('*');
                for (int j = 0; j < s; j++) sb.append(' ');
                sb.append('*');
            } else if (i == t) {
                // horizontal line in the middle
                int w = (s << 1) + 3;
                for (int j = 0; j < w; j++) sb.append('*');
            } else {
                // handle
                for (int j = 0; j <= s; j++) sb.append(' ');
                sb.append('*');
            }
        }
        System.out.println(sb);
    }
}
