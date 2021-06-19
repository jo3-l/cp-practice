package binarysearch;

public class SkipTasksToMinimizeWork {
    private int[][] dp;

    public int solve(int[] nums) {
        dp = new int[nums.length][2];
        return go(nums, 0, 0);
    }

    private int go(int[] tasks, int i, int skippedLast) {
        if (i == tasks.length) return 0;
        if (dp[i][skippedLast] != 0) return dp[i][skippedLast];
        int cost = tasks[i];
        return dp[i][skippedLast] = Math.min(
                // skip current one
                skippedLast == 1 ? Integer.MAX_VALUE : go(tasks, i + 1, 1),
                // don't skip
                cost + go(tasks, i + 1, 0)
        );
    }
}
