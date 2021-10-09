package binarysearch;

import java.util.HashMap;
import java.util.Map;

public class ArithmeticSubsequences {
    public int solve(int[] nums) {
        int N = nums.length;
        @SuppressWarnings("unchecked")
        Map<Integer, int[]>[] dp = new HashMap[N];
        int R = 0;
        for (int i = 0; i < N; i++) {
            dp[i] = new HashMap<>();
            for (int j = 0; j < i; j++) {
                int diff = nums[i] - nums[j];
                // k is the length of the subsequence; 4 denotes length > 3
                for (int k = 2; k <= 4; k++) {
                    int pos = k - 2;
                    if (k == 2) {
                        // we can always make a subsequence of length 2.
                        dp[i].computeIfAbsent(diff, kk -> new int[3])[pos]++;
                    } else if (k == 3) {
                        int[] pdp = dp[j].get(diff);
                        if (pdp != null) {
                            dp[i].computeIfAbsent(diff, kk -> new int[3])[pos] += pdp[pos - 1];
                            R += dp[i].get(diff)[pos];
                        }
                    } else {
                        int[] pdp = dp[j].get(diff);
                        if (pdp != null) {
                            dp[i].computeIfAbsent(diff, kk -> new int[3])[pos] += pdp[pos - 1] + pdp[pos];
                            R += dp[i].get(diff)[pos];
                        }
                    }
                }
            }
        }

        return R;
    }
}
