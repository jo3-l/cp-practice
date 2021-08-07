package binarysearch;

public class TurtleOfWallStreet {
    public int solve(int[] nums) {
        if (nums.length == 0) return 0;
        int[] ma = new int[nums.length];
        ma[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i>= 0; i--) ma[i] = Math.max(ma[i + 1], nums[i]);
        int p = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            int cur = ma[i + 1] - nums[i];
            if (cur > 0) p += cur;
        }
        return p;
    }
}
