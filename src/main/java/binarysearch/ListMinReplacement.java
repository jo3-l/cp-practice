package binarysearch;

public class ListMinReplacement {
    public int[] solve(int[] nums) {
        int[] res = new int[nums.length];
        res[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res[i] = i == 1 ? nums[i - 1] : Math.min(nums[i - 1], res[i - 1]);
        }
        res[0] = 0;
        return res;
    }
}
