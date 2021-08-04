package binarysearch;

import java.util.*;

public class PairSumsToPowerOfTwo {
    public int solve(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int n : nums) {
            freq.merge(n, 1, Integer::sum);
        }

        int j = 0;
        for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
            int n = e.getKey();
            int f = e.getValue();
            for (int i = 0; i < 32; i++) {
                int other = (1 << i) - n;
                if (other > n) continue;
                int of = freq.getOrDefault(other, 0);
                if (other == n) {
                    j += (f * (f - 1)) >> 1;
                } else {
                    j += of * f;
                }
            }
        }
        return j;
    }
}
