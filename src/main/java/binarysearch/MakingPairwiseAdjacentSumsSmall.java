package binarysearch;

public class MakingPairwiseAdjacentSumsSmall {
    public int solve(int[] nums, int k) {
        final int MOD = (int) 1e9 + 7;
        long n = 0;
        for (int i = 0, j = 1; j < nums.length; i++, j++) {
            int o = nums[i] + nums[j] - k;
            if (o > 0) {
                if (nums[j] > 0) {
                    int s = Math.min(o, nums[j]);
                    nums[j] -= s;
                    n += s;
                    o -= s;
                    n %= MOD;
                }
                if (o > 0) {
                    nums[i] -= o;
                    n += o;
                    n %= MOD;
                }
            }
        }
        return (int) (n % MOD);
    }
}
