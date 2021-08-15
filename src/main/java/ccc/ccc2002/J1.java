package ccc.ccc2002;

import java.util.Scanner;

public class J1 {
    public static void main(String[] args) {
        final int S = 8; // space
        final int N = 9; // newline
        final int[] state = {
                S, 1, S, 1, S, 1, S, N,
                2, S, S, S, S, S, 3, N,
                2, S, S, S, S, S, 3, N,
                2, S, S, S, S, S, 3, N,
                S, 4, S, 4, S, 4, S, N,
                5, S, S, S, S, S, 6, N,
                5, S, S, S, S, S, 6, N,
                5, S, S, S, S, S, 6, N,
                S, 7, S, 7, S, 7, S, N,
        };
        final int[] segments = {
                (1<<1) | (1<<2) | (1<<3) | (1<<5) | (1<<6) | (1<<7),
                (1<<3) | (1<<6),
                (1<<1) | (1<<3) | (1<<4) | (1<<5) | (1<<7),
                (1<<1) | (1<<3) | (1<<4) | (1<<6) | (1<<7),
                (1<<2) | (1<<3) | (1<<4) | (1<<6),
                (1<<1) | (1<<2) | (1<<4) | (1<<6) | (1<<7),
                (1<<1) | (1<<2) | (1<<4) | (1<<5) | (1<<6) | (1<<7),
                (1<<1) | (1<<3) | (1<<6),
                (1<<1) | (1<<2) | (1<<3) | (1<<4) | (1<<5) | (1<<6) | (1<<7),
                (1<<1) | (1<<2) | (1<<3) | (1<<4) | (1<<6) | (1<<7),
        };

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int segment = segments[n];
        StringBuilder sb = new StringBuilder();
        for (int v : state) {
            if (v == N) {
                // trim end
                while (sb.length() > 0 && sb.charAt(sb.length() - 1) == ' ') sb.deleteCharAt(sb.length() - 1);
                sb.append('\n');
            } else if ((segment & (1 << v)) != 0) {
                sb.append('*');
            } else {
                sb.append(' ');
            }
        }
        System.out.print(sb);
    }
}
