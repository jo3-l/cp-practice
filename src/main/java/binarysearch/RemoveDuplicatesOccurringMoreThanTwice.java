package binarysearch;

import java.util.ArrayList;
import java.util.List;

public class RemoveDuplicatesOccurringMoreThanTwice {
    public int[] solve(int[] nums) {
        List<Integer> ret = new ArrayList<>();

        int i = 0;
        while (i < nums.length) {
            int ni = next(nums, nums[i]);
            int count = Math.min(ni - i, 2);
            for (int z = 0; z < count; z++) ret.add(nums[i]);
            i = ni;
        }
        int[] vv = new int[ret.size()];
        for (int j = 0; j < ret.size(); j++) vv[j] = ret.get(j);
        return vv;
    }

    private int next(int[] nums, int v) {
        // find first elem > v
        int high = nums.length - 1;
        int low = 0;
        while (low < high) {
            int mid = (low + high) >> 1;
            if (nums[mid] > v) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return nums[low] > v ? low : nums.length;
    }
}
