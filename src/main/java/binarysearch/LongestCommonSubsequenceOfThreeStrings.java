package binarysearch;

public class LongestCommonSubsequenceOfThreeStrings {
    public int solve(String a, String b, String c) {
        if (a.isEmpty() || b.isEmpty() || c.isEmpty()) return 0;
        int[][][] dp = new int[a.length()][b.length()][c.length()];
        for (int i = 0; i < a.length(); i++) {
            for (int j = 0; j < b.length(); j++) {
                for (int k = 0; k < c.length(); k++) {
                    if (a.charAt(i) == b.charAt(j) && a.charAt(i) == c.charAt(k)) {
                        dp[i][j][k] = (i > 0 && j > 0 && k > 0 ? dp[i - 1][j - 1][k - 1] : 0) + 1;
                    } else {
                        dp[i][j][k] = Math.max(
                                i > 0 ? dp[i - 1][j][k] : 0,
                                Math.max(
                                        j > 0 ? dp[i][j - 1][k] : 0,
                                        k > 0 ? dp[i][j][k - 1] : 0
                                )
                        );
                    }
                }
            }
        }
        return dp[a.length() - 1][b.length() - 1][c.length() - 1];
    }
}
