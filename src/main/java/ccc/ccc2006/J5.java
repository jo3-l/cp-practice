package ccc.ccc2006;

import java.util.Scanner;

public class J5 {
    public static void main(String[] args) {
        int[][] board = new int[8][8]; // 0 -> unused, 1 -> white, 2 -> black

        Scanner sc = new Scanner(System.in);
        char conf = sc.next(".").charAt(0);
        if (conf == 'a') {
            board[3][3] = 1;
            board[4][4] = 1;
            board[4][3] = 2;
            board[3][4] = 2;
        } else if (conf == 'b') {
            for (int i = 0; i < 8; i++) {
                board[i][i] = 2;
                board[i][7 - i] = 1;
            }
        } else {
            for (int i = 0; i < 8; i++) {
                for (int j = 2; j < 6; j++) {
                    board[i][j] = j < 4 ? 2 : 1;
                }
            }
        }

        int N = sc.nextInt();
        for (int ctr = 0; ctr < N; ctr++) {
            int r = sc.nextInt() - 1;
            int c = sc.nextInt() - 1;
            int player = 2 - (ctr & 1);
            int other = 3 - player;
            board[r][c] = player;

            // check horizontal
            int j = c - 1;
            while (j >= 0 && board[r][j] != 0) {
                if (board[r][j] == other) {
                    j--;
                    continue;
                }
                for (int z = j + 1; z < c; z++) board[r][z] = player;
                break;
            }
            j = c + 1;
            while (j < 8 && board[r][j] != 0) {
                if (board[r][j] == other) {
                    j++;
                    continue;
                }
                for (int z = j - 1; z >= c; z--) board[r][z] = player;
                break;
            }

            // check vertical
            int i = r - 1;
            while (i >= 0 && board[i][c] != 0) {
                if (board[i][c] == other) {
                    i--;
                    continue;
                }
                for (int z = i + 1; z < r; z++) board[z][c] = player;
                break;
            }
            i = r + 1;
            while (i < 8 && board[i][c] != 0) {
                if (board[i][c] == other) {
                    i++;
                    continue;
                }
                for (int z = i - 1; z >= r; z--) board[z][c] = player;
                break;
            }

            // check diag moving right
            int ii = r - 1;
            int jj = c - 1;
            while (ii >= 0 && jj >= 0 && board[ii][jj] != 0) {
                if (board[ii][jj] == other) {
                    ii--;
                    jj--;
                    continue;
                }
                for (int iii = ii + 1, jjj = jj + 1; iii < r; iii++, jjj++) board[iii][jjj] = player;
                break;
            }
            ii = r + 1;
            jj = c + 1;
            while (ii < 8 && jj < 8 && board[ii][jj] != 0) {
                if (board[ii][jj] == other) {
                    ii++;
                    jj++;
                    continue;
                }
                for (int iii = ii - 1, jjj = jj - 1; iii >= r; iii--, jjj--) board[iii][jjj] = player;
                break;
            }

            // check diag moving left
            ii = r + 1;
            jj = c - 1;
            while (ii < 8 && jj >= 0 && board[ii][jj] != 0) {
                if (board[ii][jj] == other) {
                    ii++;
                    jj--;
                    continue;
                }
                for (int iii = ii - 1, jjj = jj + 1; iii >= r; iii--, jjj++) board[iii][jjj] = player;
                break;
            }
            ii = r - 1;
            jj = c + 1;
            while (ii >= 0 && jj < 8 && board[ii][jj] != 0) {
                if (board[ii][jj] == other) {
                    ii--;
                    jj++;
                    continue;
                }
                for (int iii = ii + 1, jjj = jj - 1; iii < r; iii++, jjj--) board[iii][jjj] = player;
                break;
            }
        }

        int black = 0;
        int white = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == 1) white++;
                else if (board[i][j] == 2) black++;
            }
        }
        System.out.println(black + " " + white);
    }
}
