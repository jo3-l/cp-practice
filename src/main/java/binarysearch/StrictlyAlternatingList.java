package binarysearch;

public class StrictlyAlternatingList {
    public boolean solve(int[] nums) {
        boolean wasIncreasing = false;
        int i = 0;
        while (i < nums.length - 1) {
            int mark = i;
            while (i < nums.length - 1 && (wasIncreasing ? nums[i + 1] < nums[i] : nums[i + 1] > nums[i])) {
                i++;
            }
            if (i == mark) return false;
            wasIncreasing = !wasIncreasing;
        }
        return true;
    }
}
