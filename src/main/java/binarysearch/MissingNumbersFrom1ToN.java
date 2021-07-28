package binarysearch;

import java.util.BitSet;

public class MissingNumbersFrom1ToN {
    public int[] solve(int[] nums) {
        int N = nums.length;
        BitSet seen = new BitSet(N + 1);
        for (int n : nums) seen.set(n);

        int[] ret = new int[N - seen.cardinality()];
        int j = 0;
        for (int i = 1; i <= nums.length; i++) {
            if (!seen.get(i)) ret[j++] = i;
        }
        return ret;
    }
}
