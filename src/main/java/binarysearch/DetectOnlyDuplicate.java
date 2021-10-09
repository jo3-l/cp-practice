package binarysearch;

public class DetectOnlyDuplicate {
    public int solve(int[] nums) {
        int total = 0;
        int want = (nums.length * (nums.length - 1))  >> 1;
        for (int num : nums) total += num;
        return total - want;
    }
}
