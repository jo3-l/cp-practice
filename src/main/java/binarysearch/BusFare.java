package binarysearch;

public class BusFare {
    private int[] dp;

    public int solve(int[] days) {
        dp = new int[days.length];
        return go(days, 0);
    }

    private int go(int[] days, int curIdx) {
        if (curIdx == days.length) return 0;
        if (dp[curIdx] != 0) return dp[curIdx];
        int curDay = days[curIdx];
        int week = findIdx(days, curDay + 7);
        int month = findIdx(days, curDay + 30);
        return dp[curIdx] = Math.min(
                Math.min(
                        // buy a 1 day pass
                        2 + go(days, curIdx + 1),
                        // buy a 7 day pass
                        7 + go(days, week + 1)
                ),
                // buy a 30 day pass
                25 + go(days, month + 1)
        );
    }

    private int findIdx(int[] days, int target) {
        // find last number in days which is < target.
        int high = days.length - 1;
        int low = 0;
        while (low < high) {
            int mid = (low + high + 1) >> 1;
            if (days[mid] < target) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }

        return days[low] < target ? low : days.length;
    }
}
