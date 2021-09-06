package binarysearch;

import java.util.Arrays;

public class PrisonCells {
    public int[] solve(int[] nums, int k) {
        int[] cycle = new int[1 << 8];
        Arrays.fill(cycle, -1);
        int[] prev = new int[1 << 8];
        prev[0] = enc(nums);
        cycle[prev[0]] = 0;
        for (int n = 1; n <= k; n++) {
            prev[n] = next(prev[n - 1]);
            if (cycle[prev[n]] != -1) {
                k -= n;
                return dec(prev[(k % (n - cycle[prev[n]])) + cycle[prev[n]]]);
            }
            cycle[prev[n]] = n;
        }
        return dec(prev[k]);
    }

    private int next(int old) {
        int res = 0;
        for (int i = 1; i < 7; i++) {
            boolean prevSet = (old & (1 << (i - 1))) != 0;
            boolean nextSet = (old & (1 << (i + 1))) != 0;
            if (prevSet == nextSet) res |= 1 << i;
        }
        return res;
    }

    private int enc(int[] nums) {
        int r = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) r |= 1 << i;
        }
        return r;
    }

    private int[] dec(int r) {
        int[] v = new int[8];
        for (int i = 0; i < 8; i++) {
            if ((r & (1 << i)) != 0) v[i] = 1;
        }
        return v;
    }
}
