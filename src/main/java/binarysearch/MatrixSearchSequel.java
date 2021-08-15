package binarysearch;

public class MatrixSearchSequel {
    public boolean solve(int[][] matrix, int target) {
        for (int[] r : matrix) if (exists(r, target)) return true;
        return false;
    }

    private boolean exists(int[] r, int t) {
        int lo = 0;
        int hi = r.length - 1;
        if (r[lo] > t) return false;
        while (lo <= hi) {
            int mid = (lo + hi) >> 1;
            if (r[mid] > t) hi = mid - 1;
            else if (r[mid] == t) return true;
            else lo = mid + 1;
        }
        return false;
    }
}
