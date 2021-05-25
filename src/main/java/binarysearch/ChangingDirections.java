package binarysearch;

public class ChangingDirections {
    public int solve(int[] nums) {
        if (nums.length <= 2) return 0;

        int n = 0;
        for (int i = 1; i < nums.length - 1; i++) {
            int num = nums[i];
            int lastSlope = num - nums[i - 1];
            int curSlope = nums[i + 1] - num;

            int diff = Math.abs(Integer.signum(lastSlope) - Integer.signum(curSlope));
            if (diff == 2) n++;
        }

        return n;
    }
}
