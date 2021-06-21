package binarysearch;

public class LongestConsecutiveRunsOf1s {
    public int solve(int n) {
        int best = 0;
        int cur = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                cur++;
            } else {
                best = Math.max(best, cur);
                cur = 0;
            }
        }
        return best;
    }
}
