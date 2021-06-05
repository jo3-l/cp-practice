package binarysearch;

import java.util.HashSet;
import java.util.Set;

public class PythagoreanTriplets {
    public boolean solve(int[] nums) {
        Set<Integer> vs = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            nums[i] *= nums[i];
            vs.add(nums[i]);
        }

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (vs.contains(nums[i] + nums[j])) return true;
            }
        }
        return false;
    }
}
