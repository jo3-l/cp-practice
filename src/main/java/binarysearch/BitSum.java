package binarysearch;

public class BitSum {
    public int solve(int[] nums, int k) {
        int M = 1000000007;
        int[] v = new int[32];

        int t = 0;
        for (int num : nums) {
            t += num;
            t %= M;
            for (int i = 0; i < 31; i++) {
                if ((num & (1 << i)) == 0) v[i]++;
            }
        }

        int cur = 0;
        for (int i = 0; i < k; i++) {
            while (v[cur] == 0) cur++;
            t += 1 << cur;
            v[cur]--;
            t %= M;
        }
        return t;
    }
}
