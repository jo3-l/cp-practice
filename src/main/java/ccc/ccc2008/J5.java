package ccc.ccc2008;

import java.util.Scanner;

public class J5 {
    private static int[][][][] lossDp = new int[31][31][31][31]; // 0 -> unknown, 1 -> true, 2 -> false
    private static int[][][][] winDp = new int[31][31][31][31];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        while (N-- > 0) {
            String[] parts = sc.nextLine().split(" ");
            int a = Integer.parseInt(parts[0]);
            int b = Integer.parseInt(parts[1]);
            int c = Integer.parseInt(parts[2]);
            int d = Integer.parseInt(parts[3]);
            System.out.println(isWin(a, b, c, d) == 1 ? "Patrick" : "Roland");
        }
    }

    // Return 1 iff all valid moves after this one lead to a win, otherwise 2.
    private static int isWin(int a, int b, int c, int d) {
        if (winDp[a][b][c][d] != 0) return winDp[a][b][c][d];
        return winDp[a][b][c][d] = ((can(a - 2, b - 1, c, d - 2) && isLoss(a - 2, b - 1, c, d - 2) == 1)
                || (can(a - 1, b - 1, c - 1, d - 1) && isLoss(a - 1, b - 1, c - 1, d - 1) == 1)
                || (can(a, b, c - 2, d - 1) && isLoss(a, b, c - 2, d - 1) == 1)
                || (can(a, b - 3, c, d) && isLoss(a, b - 3, c, d) == 1)
                || (can(a - 1, b, c, d - 1) && isLoss(a - 1, b, c, d - 1) == 1)) ? 1 : 2;
    }

    // Return 1 iff all valid moves after this one lead to a loss, otherwise 2.
    private static int isLoss(int a, int b, int c, int d) {
        if (lossDp[a][b][c][d] != 0) return lossDp[a][b][c][d];
        return lossDp[a][b][c][d] = ((!can(a - 2, b - 1, c, d - 2) || isWin(a - 2, b - 1, c, d - 2) == 1)
                && (!can(a - 1, b - 1, c - 1, d - 1) || isWin(a - 1, b - 1, c - 1, d - 1) == 1)
                && (!can(a, b, c - 2, d - 1) || isWin(a, b, c - 2, d - 1) == 1)
                && (!can(a, b - 3, c, d) || isWin(a, b - 3, c, d) == 1)
                && (!can(a - 1, b, c, d - 1) || isWin(a - 1, b, c, d - 1) == 1)) ? 1 : 2;
    }

    private static boolean can(int a, int b, int c, int d) {
        return a >= 0 && b >= 0 && c >= 0 && d >= 0;
    }
}
