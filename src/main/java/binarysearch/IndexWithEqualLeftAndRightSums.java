package binarysearch;

public class IndexWithEqualLeftAndRightSums {
    public int solve(int[] nums) {
        int left = 0;
        int right = 0;
        for (int num : nums) right += num;

        int i = 0;
        while (i < nums.length && left != right) {
            if (i > 0) left += nums[i - 1];
            right -= nums[i++];

            if (left == right) return i - 1;
        }
        return -1;
    }
}

