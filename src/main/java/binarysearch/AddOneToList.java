package binarysearch;

public class AddOneToList {
    public int[] solve(int[] nums) {
        int i = nums.length;
        while (i-- > 0) {
            if (nums[i]++ == 9) nums[i] = 0;
            else break;
        }
        if (i != -1 || nums[0] != 0) return nums;

        int[] cop = new int[nums.length + 1];
        System.arraycopy(nums, 0, cop, 1, nums.length);
        cop[0] = 1;
        return cop;
    }
}
