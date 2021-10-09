package binarysearch;

import java.util.BitSet;

public class ZeroMatrix {
    public int[][] solve(int[][] matrix) {
        BitSet zeroCols = new BitSet();
        BitSet zeroRows = new BitSet();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    zeroCols.set(j);
                    zeroRows.set(i);
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (zeroCols.get(j) || zeroRows.get(i)) matrix[i][j] = 0;
            }
        }
        return matrix;
    }
}
