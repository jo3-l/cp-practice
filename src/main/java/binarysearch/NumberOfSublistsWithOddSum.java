package binarysearch;

public class NumberOfSublistsWithOddSum {
    private final int MOD = (int) 1e9 + 7;

    public int solve(int[] nums) {
        if (nums.length == 0) return 0;

        // dp[i][j] is the number of sublists ending at i.
        // j specifies whether the sublist sum was even(0) / odd(1).
        int[][] dp = new int[nums.length][2];
        dp[0][nums[0] & 1] = 1;
        int n = dp[0][1];
        for (int i = 1; i < nums.length; i++) {
            if ((nums[i] & 1) == 0) {
                dp[i][0] = 1; // start new sublist
                dp[i][0] += dp[i - 1][0]; // even + even = even
                dp[i][1] = dp[i - 1][1]; // odd + even = odd
            } else {
                dp[i][1] = 1; // start new sublist
                dp[i][1] += dp[i - 1][0]; // even + odd = odd
                dp[i][0] = dp[i - 1][1]; // odd + odd = even
            }

            n += dp[i][1];
            n %= MOD;
        }
        return n;
    }
}
