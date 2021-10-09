package binarysearch;

import java.util.Arrays;

public class MaxMultipliedPairings {
    public int solve(int[] nums, int[] multipliers) {
        if (nums.length > multipliers.length) {
            int[] tmp = nums;
            nums = multipliers;
            multipliers = tmp;
        }

        Arrays.sort(nums);
        Arrays.sort(multipliers);
        int sum = 0;
        int j = 0;
        int k = multipliers.length - countPos(nums);
        for (int num : nums) {
            if (num <= 0) sum += num * multipliers[j++]; // pair lesser numbers with lesser multipliers
            else sum += num * multipliers[k++]; // pair greater numbers with greater multipliers
        }
        return sum;
    }

    private int countPos(int[] nums) {
        if (nums.length == 0) return 0;
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            int mid = (lo + hi) >> 1;
            if (nums[mid] > 0) hi = mid;
            else lo = mid + 1;
        }
        return nums[lo] > 0 ? nums.length - lo : 0;
    }
}
