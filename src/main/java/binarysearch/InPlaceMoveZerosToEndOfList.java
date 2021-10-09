package binarysearch;

public class InPlaceMoveZerosToEndOfList {
    public int[] solve(int[] nums) {
        int writeIdx = 0;
        int idx = 0;
        while (idx < nums.length) {
            int v = nums[idx++];
            if (v != 0) nums[writeIdx++] = v;
        }
        for (int j = writeIdx; j < nums.length; j++) nums[j] = 0;
        return nums;
    }
}
