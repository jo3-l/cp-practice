package binarysearch;

public class UniqueIntegersInSortedList {
    public int solve(int[] nums) {
        int n = 0;

        int i = 0;
        while (i < nums.length && i != -1) {
            n++;
            i = findGreaterIdx(nums, nums[i]);
        }

        return n;
    }

    // findGreaterIdx finds the first index in the sorted array nums which has an element > target.
    // It returns -1 if no such element could be found.
    private int findGreaterIdx(int[] nums, int target) {
        int high = nums.length - 1;
        int low = 0;
        while (low < high) {
            int mid = (low + high) >> 1;
            if (nums[mid] > target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return nums[low] > target ? low : -1;
    }
}
