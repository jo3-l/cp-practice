package binarysearch;

public class CoincidenceSearch {
    public int solve(int[] nums) {
        int n = 0;
        for (int i = 0; i < nums.length; i++) {
            if (search(nums, nums[i]) == i) n++;
        }
        return n;
    }

    private int search(int[] nums, int n) {
        int hi = nums.length - 1;
        int lo = 0;
        while (lo <= hi) {
            int mid = (lo + hi) >> 1;
            if (nums[mid] == n) {
                return mid;
            } else if (nums[mid] > n) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return -1;
    }
}
