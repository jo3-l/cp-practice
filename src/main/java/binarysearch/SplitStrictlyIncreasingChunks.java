package binarysearch;

import java.util.HashMap;
import java.util.Map;

public class SplitStrictlyIncreasingChunks {
    public boolean solve(int[] nums, int k) {
        if (nums.length < k) return false;
        if (k == 0 || k == 2) return true;

        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : nums) {
            counts.merge(num, 1, Integer::sum);
        }

        int maxSplit = nums.length / k;
        for (int count : counts.values()) {
            if (count > maxSplit) return false;
        }
        return true;
    }
}
