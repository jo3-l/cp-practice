package binarysearch;

public class GuessTheRoot {
    private static final int MAX = (int) Math.floor(Math.sqrt(Math.pow(2, 31)));

    public int solve(int n) {
        if (n == 0) return 0;

        int low = 1;
        int high = MAX;

        // find largest integer X such that X^2 <= n
        while (low < high) {
            int mid = low + (high - low + 1) / 2;
            if (mid * mid <= n) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }
}
