package binarysearch;

public class JustAverage {
    public boolean solve(int[] nums, int k) {
        int total = 0;
        for (int num : nums) total += num;

        int wanted = k * (nums.length - 1);
        for (int num : nums) {
            if (total - num == wanted) return true;
        }
        return false;
    }
}
