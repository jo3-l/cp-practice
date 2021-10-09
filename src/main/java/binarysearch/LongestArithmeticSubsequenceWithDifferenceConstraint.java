package binarysearch;

import java.util.HashMap;
import java.util.Map;

public class LongestArithmeticSubsequenceWithDifferenceConstraint {
    public int solve(int[] nums, int diff) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 1;
        for (int num : nums) {
            map.put(num, map.getOrDefault(num - diff, 0) + 1);
            max = Math.max(max, map.get(num));
        }
        return max;
    }
}