package binarysearch;

public class SplitList {
    public boolean solve(int[] nums) {
        if (nums.length < 2) return false;

        int[] dpMin = new int[nums.length]; // X in {0, N-1} -> min number to the left of index N, including N.
        dpMin[nums.length - 1] = nums[nums.length - 1];

        int[] dpMax = new int[nums.length]; // X in {0, N-1} -> max number to the right of index N, including N.
        dpMax[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            dpMax[i] = Math.max(dpMax[i - 1], nums[i]);

            int turnedIdx = nums.length - i - 1;
            dpMin[turnedIdx] = Math.min(dpMin[turnedIdx + 1], nums[turnedIdx]);
        }

        // check if there is any index I where the maximum number to the left of index I, not including I, is less than
        // the minimum number to the right of index I, including I.
        for (int i = 1; i < nums.length; i++) {
            if (dpMax[i - 1] < dpMin[i]) {
                return true;
            }
        }
        return false;
    }
}
