package binarysearch;

public class ListPartitioningWithInequalityRelation {
    public int solve(int[] nums) {
        int[] minL = new int[nums.length];
        minL[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) minL[i] = Math.min(minL[i + 1], nums[i]);
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length - 1; i++) {
            int min = minL[i + 1];
            max = Math.max(max, nums[i]);
            if (max <= min) return i + 1;
        }

        return -1;
    }
}
