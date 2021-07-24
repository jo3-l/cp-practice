package binarysearch;

public class ArithmeticSequenceQueries {
    public int solve(int[] nums, int[][] queries) {
        if (nums.length <= 2) return queries.length;
        int[] dp = new int[nums.length]; // dp[i] = longest arithmetic sequence starting at i, including i
        dp[nums.length - 2] = 1;
        for (int i = nums.length - 3; i >= 0; i--) {
            int diff = nums[i + 1] - nums[i];
            if (diff == nums[i + 2] - nums[i + 1]) dp[i] = dp[i + 1] + 1;
            else dp[i] = 1;
        }
        int n = 0;
        for (int[] query : queries) {
            if (query[0] + dp[query[0]] >= query[1]) n++;
        }
        return n;
    }
}
