package binarysearch;

public class LatinSquare {
    public boolean solve(String[][] matrix) {
        int[] rows = new int[matrix.length];
        int[] cols = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            String[] row = matrix[i];
            for (int j = 0; j < row.length; j++) {
                int b = 1 << (row[j].charAt(0) - 'a');
                if ((rows[i] & b) != 0 || (cols[j] & b) != 0) return false;
                rows[i] |= b;
                cols[j] |= b;
            }
        }
        for (int row : rows) {
            for (int col : cols) if (row != col) return false;
        }
        return true;
    }
}
