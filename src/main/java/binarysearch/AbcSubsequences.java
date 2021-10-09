package binarysearch;

public class AbcSubsequences {
    public int solve(String s) {
        int[] dp = new int[4]; // 0 => cur is a, 1 => cur is b, 2 => cur is c
        for (int i = 0; i < s.length(); i++) {
            int o = s.charAt(i) - 'a';
            dp[o] += dp[o];
            if (o == 0) dp[o]++;
            if (o > 0) dp[o] += dp[o - 1];
        }
        return dp[2];
    }
}
