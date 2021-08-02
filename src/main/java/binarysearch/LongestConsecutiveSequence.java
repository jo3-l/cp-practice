package binarysearch;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public int solve(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for (int n : nums) s.add(n);

        int n = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!s.contains(nums[i] - 1)) {
                int j = nums[i] + 1;
                while (s.contains(j)) j++;
                n = Math.max(n, j - nums[i]);
            }
        }
        return n;
    }
}
