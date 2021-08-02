package binarysearch;

public class AllSublistsSum {
    private final int MOD = (int) 1e9 + 7;

    public int solve(int[] nums) {
        int n = 0;
        for (int i = 0; i < nums.length; i++) {
            n += binmult(nums[i], (long) (nums.length - i) * (i + 1));
            n %= MOD;
        }
        return n;
    }


    private int binmult(long a, long b) {
        a %= MOD;
        long res = 0;
        while (b > 0) {
            if ((b & 1) == 1) {
                res = (res + a) % MOD;
            }
            a = (a + a) % MOD;
            b >>= 1;
        }
        return (int) res % MOD;
    }
}
