package binarysearch;

public class ToeplitzMatrix {
    public boolean solve(int[][] matrix) {
        int rowNum = matrix.length;
        int columnNum = matrix[0].length;

        for (int rowStart = 0; rowStart < rowNum - 1; rowStart++) {
            for (int columnStart = 0; columnStart < columnNum - 1; columnStart++) {
                int lastV = Integer.MIN_VALUE;
                for (
                        int column = columnStart, row = rowStart;
                        column < columnNum && row < rowNum;
                        column++, row++
                ) {
                    int v = matrix[row][column];
                    if (lastV == Integer.MIN_VALUE) {
                        lastV = v;
                    } else if (lastV != v) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
