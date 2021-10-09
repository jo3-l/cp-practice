package binarysearch;

public class LargestPairOfPoints {
    public int solve(int[] nums, int[] values) {
        int mv = values[0] - nums[0];
        int res = mv + nums[0] + values[0];
        for (int i = 1; i < nums.length; i++) {
            mv = Math.max(mv, values[i] - nums[i]);
            int ma = nums[i] + values[i];
            res = Math.max(res, ma + mv);
        }
        return res;
    }
}
