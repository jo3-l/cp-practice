package ccc.ccc2011;

import java.util.Scanner;

public class S4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] store = new int[2][4]; /* 1st layer: 0 -> positive, 1 -> negative, 2nd layer: 0 -> Type O, 1 -> Type A, 2 -> Type B, 3 -> Type AB */;
        for (int i = 0; i < 8; i++) {
            store[(i & 1) ^ 1][i >> 1] = sc.nextInt();
        }

        int total = 0;
        total += canRecv(store, "O negative", sc.nextInt(), false, 0);
        total += canRecv(store, "O positive", sc.nextInt(), true, 0);
        total += canRecv(store, "A negative", sc.nextInt(), false, 1, 0);
        total += canRecv(store, "A positive", sc.nextInt(), true, 1, 0);
        total += canRecv(store, "B negative", sc.nextInt(), false, 2, 0);
        total += canRecv(store, "B positive", sc.nextInt(), true, 2, 0);
        total += canRecv(store, "AB negative", sc.nextInt(), false, 0, 1, 2, 3);
        total += canRecv(store, "AB positive", sc.nextInt(), true, 0, 1, 2, 3);
        System.out.println(total);
    }

    private static int canRecv(int[][] store, String name, int N, boolean isPositive, int... canReceive) {
        int ret = 0;
        if (isPositive) {
            // try positive first
            for (int i : canReceive) {
                int available = store[0][i];
                int use = Math.min(available, N);
                store[0][i] -= use;
                ret += use;
                N -= use;
                if (N == 0) break; // all done
            }
            if (N == 0) return ret;
        }

        for (int i : canReceive) {
            int available = store[1][i];
            int use = Math.min(available, N);
            store[1][i] -= use;
            ret += use;
            N -= use;
            if (N == 0) break; // all done
        }
        return ret;
    }
}
