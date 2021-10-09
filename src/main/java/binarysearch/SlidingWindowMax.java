package binarysearch;

import java.util.SortedMap;
import java.util.TreeMap;

public class SlidingWindowMax {
    public int[] solve(int[] nums, int k) {
        SortedMap<Integer, Integer> elem = new TreeMap<>();
        int[] ret = new int[nums.length - k + 1];
        for (int i = 0, j = k - 1; j < nums.length; i++, j++) {
            if (i == 0) {
                for (int z = 0; z <= j; z++) elem.merge(nums[z], 1, Integer::sum);
                ret[0] = elem.lastKey();
            } else {
                int prev = nums[i - 1];
                elem.compute(prev, (kk, v) -> v == 1 ? null : v - 1);
                elem.merge(nums[j], 1, Integer::sum);
                ret[i] = elem.lastKey();
            }
        }
        return ret;
    }
}
