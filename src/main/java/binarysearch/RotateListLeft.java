package binarysearch;

public class RotateListLeft {
    public int[] solve(int[] nums, int k) {
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int ii = i - k;
            if (ii < 0) ii += res.length;
            res[ii] = nums[i];
        }
        return res;
    }
}
