package ccc.ccc2003;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class J5S3 {
    private static final int WALL = 0;
    private static final int SPACE = 1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int remaining = sc.nextInt();
        int R = sc.nextInt();
        int C = sc.nextInt();
        int[][] rm = new int[R][C];
        sc.skip("\n");
        for (int i = 0; i < R; i++) {
            String s = sc.nextLine();
            for (int j = 0; j < C; j++) {
                rm[i][j] = s.charAt(j) == 'I' ? WALL : SPACE;
            }
        }

        List<Integer> sz = new ArrayList<>();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (rm[i][j] == SPACE) {
                    rm[i][j] = WALL;
                    sz.add(fill(rm, R, C, i, j));
                }
            }
        }
        sz.sort(Comparator.reverseOrder());

        int ok = 0;
        for (int s : sz) {
            if (remaining < s) break;
            remaining -= s;
            ok++;
        }

        String rp = ok == 1 ? "room" : "rooms";
        System.out.println(ok + " " + rp + ", " + remaining + " square metre(s) left over");
    }

    private static int fill(int[][] rm, int R, int C, int i, int j) {
        int f = 1;
        final int[] di = {1, -1, 0, 0};
        final int[] dj = {0, 0, 1, -1};
        for (int d = 0; d < 4; d++) {
            int ii = i + di[d];
            int jj = j + dj[d];
            if (ii >= 0 && ii < R && jj >= 0 && jj < C && rm[ii][jj] == SPACE) {
                rm[ii][jj] = WALL;
                f += fill(rm, R, C, ii, jj);
            }
        }
        return f;
    }
}
