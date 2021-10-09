package binarysearch;

public class TriangleTriplets {
    public int solve(int[] nums) {
        int n = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] > nums[k]
                            && nums[i] + nums[k] > nums[j]
                            && nums[j] + nums[k] > nums[i]) n++;
                }
            }
        }
        return n;
    }
}
