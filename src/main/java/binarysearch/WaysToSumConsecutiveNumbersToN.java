package binarysearch;

public class WaysToSumConsecutiveNumbersToN {
    public int solve(int target) {
        if (target == 0) return 1;
        int j = 0;
        for (int n = 1; (long) n * (n + 1) / 2 <= target; n++) {
            if (isOk(n, target)) j++;
        }
        return j;
    }

    public boolean isOk(int n, int target) {
        long doubled = (long) target << 1;
        if (doubled % n != 0) return false;
        long j = doubled / n;
        return ((j - n + 1) & 1) == 0;
    }
}
