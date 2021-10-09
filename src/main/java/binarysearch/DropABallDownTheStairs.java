package binarysearch;

import java.util.BitSet;

public class DropABallDownTheStairs {
    public int solve(int height, int[] blacklist) {
        final int MOD = (int) 1e9 + 7;

        BitSet blacklistSet = new BitSet(height + 1);
        for (int blacklisted : blacklist) blacklistSet.set(blacklisted);
        if (blacklistSet.get(height)) return 0;

        long[][] dp = new long[height + 10][2];
        dp[height][0] = 1;
        for (int cur = height - 1; cur >= 0; cur--) {
            if (!blacklistSet.get(cur)) {
                dp[cur][0] += dp[cur + 1][1];
                dp[cur][0] += dp[cur + 3][1];
                dp[cur][0] += dp[cur + 4][1];
                dp[cur][0] %= MOD;

                dp[cur][1] += dp[cur + 1][0];
                dp[cur][1] += dp[cur + 2][0];
                dp[cur][1] += dp[cur + 4][0];
                dp[cur][1] %= MOD;
            }
        }
        return (int) (dp[0][0] + dp[0][1] % MOD) % MOD;
    }
}
