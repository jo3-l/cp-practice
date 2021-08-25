package binarysearch;

public class KStackPops {
    public int solve(int[][] stacks, int k) {
        final int IMPOSSIBLE = Integer.MIN_VALUE;

        // maximum suffix sum where the number of elements removed is exactly k
        for (int[] stack : stacks) {
            for (int i = stack.length - 2; i >= 0; i--) stack[i] += stack[i + 1];
        }
        int[][] dp = new int[stacks.length][k + 1];
        int res = IMPOSSIBLE;
        for (int i = 0; i < stacks.length; i++) {
            int[] stack = stacks[i];
            for (int j = 0; j <= k; j++) {
                if (i == 0) {
                    if (j == 0) dp[i][j] = 0;
                    else if (j <= stack.length) dp[i][j] = stack[stack.length - j];
                    else dp[i][j] = IMPOSSIBLE;
                } else {
                    dp[i][j] = dp[i - 1][j];
                    boolean set = dp[i][j] != IMPOSSIBLE;
                    for (int c = stack.length - 1, n = 1; c >= 0 && n <= j; c--, n++) {
                        int prev = dp[i - 1][j - n];
                        if (prev != IMPOSSIBLE) {
                            if (!set || prev + stack[c] > dp[i][j]) {
                                dp[i][j] = prev + stack[c];
                                set = true;
                            }
                        }
                    }
                }
            }
            res = Math.max(res, dp[i][k]);
        }

        return res == IMPOSSIBLE ? 0 : res;
    }
}
