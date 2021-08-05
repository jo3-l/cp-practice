package binarysearch;

public class UniqueSubsequencesEqualToTarget {
    public int solve(String s, String t) {
        final int MOD = (int) 1e9 + 7;
        int[][] dp = new int[s.length()][t.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][0] = s.charAt(i) == t.charAt(0) ? 1 : 0;
            for (int j = 1; j < t.length(); j++) {
                if (s.charAt(i) != t.charAt(j)) continue;
                for (int m = 0; m < i; m++) {
                    dp[i][j] = (dp[i][j] % MOD) + (dp[m][j - 1] % MOD) % MOD;
                }
            }
        }
        int m = 0;
        for (int i = 0; i < s.length(); i++) m = (m % MOD) + (dp[i][t.length() - 1] % MOD) % MOD;
        return m % MOD;
    }
}
