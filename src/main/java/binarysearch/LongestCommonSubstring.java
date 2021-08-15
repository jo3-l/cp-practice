package binarysearch;

public class LongestCommonSubstring {
    public int solve(String s0, String s1) {
        int[][] dp = new int[s0.length()][s1.length()]; // dp(i, j) = longest common substring ending at s0[i], s1[j]
        int m = 0;
        for (int i = 0; i < s0.length(); i++) {
            for (int j = 0; j < s1.length(); j++) {
                if (s0.charAt(i) == s1.charAt(j)) {
                    dp[i][j] = (i > 0 && j > 0 ? dp[i - 1][j - 1] : 0) + 1;
                    m = Math.max(m, dp[i][j]);
                }
            }
        }
        return m;
    }
}
