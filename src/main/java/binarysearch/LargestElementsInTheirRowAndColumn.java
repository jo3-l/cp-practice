package binarysearch;

public class LargestElementsInTheirRowAndColumn {
    public int solve(int[][] matrix) {
        int[] rc = new int[matrix.length];
        int[] cc = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            int[] row = matrix[i];
            for (int j = 0; j < row.length; j++) {
                if (row[j] == 1) {
                    rc[i]++;
                    cc[j]++;
                }
            }
        }

        int n = 0;
        for (int i = 0; i < matrix.length; i++) {
            int[] row = matrix[i];
            for (int j = 0; j < row.length; j++) {
                if (row[j] == 1 && rc[i] == 1 && cc[j] == 1) n++;
            }
        }
        return n;
    }
}
