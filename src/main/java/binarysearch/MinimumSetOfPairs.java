package binarysearch;

import java.util.Arrays;

public class MinimumSetOfPairs {
    public int solve(int[] nums) {
        int best = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int s0 = nums[i] + nums[j];

                int lo = 0;
                int hi = nums.length - 1;
                while (lo < hi && lo != i && hi != j) {
                    int s1 = nums[lo] + nums[hi];
                    int diff = s0 - s1;
                    if (diff < 0) { // s0 < s1
                        best = Math.min(best, -diff);
                        hi--;
                    } else if (diff == 0) {
                        return 0;
                    } else { // s0 > s1
                        best = Math.min(best, diff);
                        lo++;
                    }
                }
            }
        }
        return best;
    }
}
