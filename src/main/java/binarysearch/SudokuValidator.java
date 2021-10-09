package binarysearch;

public class SudokuValidator {
    public boolean solve(int[][] matrix) {
        int[] cols = new int[9];
        int[] rows = new int[9];
        int[] boxes = new int[9];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                int val = matrix[i][j];
                if (val < 1 || val > 9) return false;
                int bit = 1 << val;

                if ((cols[j] & bit) != 0) return false;
                cols[j] |= bit;

                if ((rows[i] & bit) != 0) return false;
                rows[i] |= bit;

                int box = (i / 3) * 3 + j / 3;
                if ((boxes[box] & bit) != 0) return false;
                boxes[box] |= bit;
            }
        }

        return true;
    }
}
