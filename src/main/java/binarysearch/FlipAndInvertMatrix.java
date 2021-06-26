package binarysearch;

public class FlipAndInvertMatrix {
    public int[][] solve(int[][] matrix) {
        for (int[] row : matrix) {
            int mid = row.length >> 1;
            for (int j = 0; j < mid; j++) {
                row[j] ^= 1;
                row[row.length - j - 1] ^= 1;

                row[j] ^= row[row.length - j - 1];
                row[row.length - j - 1] ^= row[j];
                row[j] ^= row[row.length - j - 1];
            }
            if ((row.length > 0) && (row.length & 1) == 1) row[mid] ^= 1;
        }

        return matrix;
    }
}
