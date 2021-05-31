package binarysearch;

public class RangeSum {
    private final int[] prefixSum;

    public RangeSum(int[] nums) {
        prefixSum = new int[nums.length];
        if (nums.length > 0) prefixSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) prefixSum[i] = prefixSum[i - 1] + nums[i];
    }

    public int total(int i, int j) {
        return prefixSum[j - 1] - (i > 0 ? prefixSum[i - 1] : 0);
    }
}
