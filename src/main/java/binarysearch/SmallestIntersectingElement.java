package binarysearch;

public class SmallestIntersectingElement {
    public int solve(int[][] matrix) {
        if (matrix.length == 0) return -1;
        for (int x : matrix[0]) {
            int i;
            for (i = 1; i < matrix.length; i++) {
                if (!exists(matrix[i], x)) break;
            }
            if (i >= matrix.length) return x;
        }
        return -1;
    }

    private boolean exists(int[] haystack, int needle) {
        int lo = 0;
        int hi = haystack.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) >> 1;
            if (haystack[mid] > needle) hi = mid - 1;
            else if (haystack[mid] == needle) return true;
            else lo = mid + 1;
        }

        return false;
    }
}
