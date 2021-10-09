package binarysearch;

import java.util.HashSet;
import java.util.Set;

public class BomberMan {
    public int solve(int[][] matrix) {
        if (matrix.length == 0) return 0;

        Set<Integer> bombedRows = new HashSet<>();
        Set<Integer> bombedColumns = new HashSet<>();

        int columnSize = matrix.length;
        int rowSize = matrix[0].length;
        for (int i = 0; i < columnSize; i++) {
            int[] row = matrix[i];
            for (int j = 0; j < rowSize; j++) {
                if (row[j] == 1) {
                    bombedRows.add(i);
                    bombedColumns.add(j);
                }
            }
        }

        int ok = columnSize * rowSize;
        ok -= bombedRows.size() * rowSize;
        ok -= bombedColumns.size() * columnSize;
        ok += bombedRows.size() * bombedColumns.size(); // overlap

        return ok;
    }
}
