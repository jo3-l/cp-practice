package binarysearch;

import java.util.ArrayDeque;
import java.util.Queue;

public class ConvertBinaryMatrixToZeroMatrix {
    private final int[] di = {1, -1, 0, 0};
    private final int[] dj = {0, 0, -1, 1};

    public int solve(int[][] matrix) {
        if (matrix.length == 0) return 0;
        int R = matrix.length, C = matrix[0].length;
        int original = encode(matrix, R, C);
        if (original == 0) return 0;
        boolean[] seen = new boolean[1 << (R * C)];
        Queue<Integer> q = new ArrayDeque<>();
        q.add(original);
        seen[original] = true;
        int step = 1;
        while (!q.isEmpty()) {
            int sz = q.size();
            while (sz-- > 0) {
                int enc = q.poll();
                for (int i = 0; i < R; i++) {
                    for (int j = 0; j < C; j++) {
                        int app = flip(enc, i, j, R, C);
                        if (app == 0) return step;
                        if (!seen[app]) {
                            q.add(app);
                            seen[app] = true;
                        }
                    }
                }
            }
            step++;
        }
        return -1;
    }

    private int encode(int[][] matrix, int R, int C) {
        int x = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (matrix[i][j] == 1) {
                    x |= 1 << (i * C + j);
                }
            }
        }
        return x;
    }

    private int flip(int enc, int i, int j, int R, int C) {
        enc ^= 1 << (i * C + j);
        for (int d = 0; d < 4; d++) {
            int ni = i + di[d];
            int nj = j + dj[d];
            if (0 <= ni && ni < R && 0 <= nj && nj < C) {
                enc ^= 1 << (ni * C + nj);
            }
        }
        return enc;
    }
}
