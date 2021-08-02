package binarysearch;

import java.util.HashMap;
import java.util.Map;

public class LongestDistinctSublist {
    public int solve(int[] nums) {
        Map<Integer, Integer> lastOccurrence = new HashMap<>();
        int max = Math.min(1, nums.length);
        int j = -1;
        for (int i = 0; i < nums.length; i++) {
            j = Math.max(j, lastOccurrence.getOrDefault(nums[i], -1));
            lastOccurrence.put(nums[i], i);
            int len = i - j;
            max = Math.max(max, len);
        }
        return max;
    }
}
