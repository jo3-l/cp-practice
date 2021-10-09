package binarysearch;

import java.util.HashSet;
import java.util.Set;

public class SumOfTwoNumbers {
    public boolean solve(int[] nums, int k) {
        boolean canEq = (k & 1) == 0;
        int half = k / 2;

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (canEq && num == half && set.contains(num)) return true;
            set.add(num);
        }

        for (int val : set) {
            if (k == val * 2) continue;
            if (set.contains(k - val)) return true;
        }
        return false;
    }
}
