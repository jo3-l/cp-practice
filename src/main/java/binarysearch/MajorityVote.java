package binarysearch;

public class MajorityVote {
    public int solve(int[] nums) {
        int idx = 0;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[idx] == nums[i]) count++;
            else count--;
            if (count == 0) {
                idx = i;
                count = 1;
            }
        }
        int v = nums[idx];
        int votes = 0;
        for (int num : nums) {
            if (num == v) votes++;
        }
        return votes > nums.length >> 1 ? v : -1;
    }
}
