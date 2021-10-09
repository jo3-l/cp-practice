package binarysearch;

public class CompleteAnArithmeticSequence {
    public int solve(int[] nums) {
        if (nums.length == 2) return (nums[0] + nums[1]) >> 1;
        if (nums.length == 3) {
            int g0 = nums[1] - nums[0];
            int g1 = nums[2] - nums[1];
            if (Math.abs(g0) < Math.abs(g1)) return nums[1] + g0;
            return nums[0] + g1;
        }
        int g0 = nums[1] - nums[0];
        int f0 = 1;
        int g1 = nums[2] - nums[1];
        int f1 = 1;
        for (int i = 3; i < nums.length; i++) {
            int gap = nums[i] - nums[i - 1];
            if (gap == g0) f0++;
            else f1++;
        }
        int gap = f0 > f1 ? g0 : g1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] != gap) return nums[i - 1] + gap;
        }
        return nums[0];
    }
}
