package binarysearch;

public class MakingListValuesEqual {
    public int solve(int[] nums) {
        if (nums.length < 2) return 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        return max - min;
    }
}
