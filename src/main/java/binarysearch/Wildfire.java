package binarysearch;

import java.util.ArrayDeque;
import java.util.Queue;

public class Wildfire {
    public int solve(int[][] matrix) {
        Queue<int[]> q = new ArrayDeque<>();
        int remaining = 0;
        for (int i = 0; i < matrix.length; i++) {
            int[] row = matrix[i];
            for (int j = 0; j < row.length; j++) {
                if (row[j] == 2) q.add(new int[]{i, j});
                else if (row[j] == 1) remaining++;
            }
        }

        if (remaining == 0) return 0;

        int days = 1;
        while (!q.isEmpty()) {
            int genSize = q.size();
            while (genSize-- > 0) {
                int[] loc = q.poll();
                if (shouldCatchFire(loc[0] + 1, loc[1], matrix)) {
                    remaining--;
                    matrix[loc[0] + 1][loc[1]] = 2;
                    q.add(new int[]{loc[0] + 1, loc[1]});
                }
                if (shouldCatchFire(loc[0] - 1, loc[1], matrix)) {
                    remaining--;
                    matrix[loc[0] - 1][loc[1]] = 2;
                    q.add(new int[]{loc[0] - 1, loc[1]});
                }
                if (shouldCatchFire(loc[0], loc[1] + 1, matrix)) {
                    remaining--;
                    matrix[loc[0]][loc[1] + 1] = 2;
                    q.add(new int[]{loc[0], loc[1] + 1});
                }
                if (shouldCatchFire(loc[0], loc[1] - 1, matrix)) {
                    remaining--;
                    matrix[loc[0]][loc[1] - 1] = 2;
                    q.add(new int[]{loc[0], loc[1] - 1});
                }
            }

            if (remaining == 0) return days;
            days++;
        }

        return -1;
    }

    private boolean shouldCatchFire(int i, int j, int[][] matrix) {
        if (i < 0 || i >= matrix.length) return false;
        if (j < 0 || j >= matrix[0].length) return false;
        return matrix[i][j] == 1;
    }
}
