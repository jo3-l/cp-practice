package binarysearch;

import java.util.*;

public class DiagonalSort {
    public int[][] solve(int[][] matrix) {
        int rowNum = matrix.length;
        int columnNum = matrix[0].length;

        List<Integer> vals = new ArrayList<>();
        for (int rowStart = 0; rowStart < rowNum - 1; rowStart++) {
            for (int columnStart = 0; columnStart < columnNum - 1; columnStart++) {
                for (
                        int column = columnStart, row = rowStart;
                        column < columnNum && row < rowNum;
                        column++, row++
                ) {
                    vals.add(matrix[row][column]);
                }

                vals.sort(Comparator.naturalOrder());

                Iterator<Integer> iter = vals.iterator();
                for (
                        int column = columnStart, row = rowStart;
                        column < columnNum && row < rowNum;
                        column++, row++
                ) {
                    matrix[row][column] = iter.next();
                }

                vals.clear();
            }
        }

        return matrix;
    }
}
