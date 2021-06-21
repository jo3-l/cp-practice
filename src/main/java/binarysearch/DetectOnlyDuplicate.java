package binarysearch;

import java.util.BitSet;

public class DetectOnlyDuplicate {
    public int solve(int[] nums) {
        BitSet b = new BitSet(nums.length);
        for (int n : nums) {
            if (b.get(n)) return n;
            b.set(n);
        }
        return -1;
    }
}
