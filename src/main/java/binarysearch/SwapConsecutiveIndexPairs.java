package binarysearch;

public class SwapConsecutiveIndexPairs {
    public int[] solve(int[] nums) {
        for (int i = 2; i < nums.length; i += 4) {
            int tmp = nums[i - 2];
            nums[i - 2] = nums[i];
            nums[i] = tmp;
        }
        for (int i = 3; i < nums.length; i += 4) {
            int tmp = nums[i - 2];
            nums[i - 2] = nums[i];
            nums[i] = tmp;
        }
        return nums;
    }
}
