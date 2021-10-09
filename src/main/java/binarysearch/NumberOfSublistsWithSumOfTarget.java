package binarysearch;

import java.util.HashMap;
import java.util.Map;

public class NumberOfSublistsWithSumOfTarget {
    public int solve(int[] nums, int target) {
        int s = 0;
        Map<Integer, Integer> f = new HashMap<>();
        int x = 0;
        for (int i = 0; i < nums.length; i++) {
            s += nums[i];
            if (s == target) x++;
            x += f.getOrDefault(s - target, 0);
            f.merge(s, 1, Integer::sum);
        }
        return x;
    }
}
