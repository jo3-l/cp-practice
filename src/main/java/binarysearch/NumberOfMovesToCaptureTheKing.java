package binarysearch;

import java.util.ArrayDeque;
import java.util.Queue;

public class NumberOfMovesToCaptureTheKing {
    public int solve(int[][] board) {
        int R = board.length;
        int C = board[0].length;
        Queue<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (board[i][j] == 1) q.add(new int[]{i, j});
            }
        }

        final int[] di = {-2, -2, -1, 1, 2,  2,  1, -1};
        final int[] dj = {-1,  1,  2, 2, 1, -1, -2, -2};
        int move = 1;
        while (!q.isEmpty()) {
            int s = q.size();
            while (s-- > 0) {
                int[] e = q.poll();
                int i = e[0];
                int j = e[1];
                for (int d = 0; d < 8; d++) {
                    int ii = di[d] + i;
                    int jj = dj[d] + j;
                    if (ii >= 0 && ii < R && jj >= 0 && jj < C && board[ii][jj] != 1) {
                        if (board[ii][jj] == 2) return move;
                        board[ii][jj] = 1;
                        q.add(new int[]{ii, jj});
                    }
                }
            }

            move++;
        }
        return -1;
    }
}
