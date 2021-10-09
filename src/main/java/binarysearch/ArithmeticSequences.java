package binarysearch;

public class ArithmeticSequences {
    public int solve(int[] nums) {
        if (nums.length < 3) return 0;
        int[] dp = new int[nums.length]; // dp[i] = longest arithmetic sequence starting at i, including i
        dp[nums.length - 2] = 1;
        for (int i = nums.length - 3; i >= 0; i--) {
            int diff = nums[i + 1] - nums[i];
            if (diff == nums[i + 2] - nums[i + 1]) dp[i] = dp[i + 1] + 1;
            else dp[i] = 1;
        }

        int n = 0;
        for (int l : dp) {
            if (l >= 2) n += l - 1;
        }
        return n;
    }
}
