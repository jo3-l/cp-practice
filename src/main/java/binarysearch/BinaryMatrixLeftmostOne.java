package binarysearch;

public class BinaryMatrixLeftmostOne {
    public int solve(int[][] matrix) {
        int best = -1;
        for (int[] ints : matrix) {
            int sol = idx(ints);
            if (sol != -1 && (best == -1 || sol < best)) best = sol;
        }
        return best;
    }

    private int idx(int[] row) {
        // find leftmost 1
        int high = row.length - 1;
        int low = 0;
        while (low < high) {
            int mid = (high + low) >> 1;
            if (row[mid] == 1) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return row[low] == 1 ? low : -1;
    }
}
