package binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubmajorityVote {
    public int[] solve(int[] nums) {
        Arrays.sort(nums);
        List<Integer> ret = new ArrayList<>();
        int want = (int) Math.floor((double) nums.length / 3);
        int i = 0;
        while (i < nums.length) {
            int v = next(nums, nums[i]);
            if (v - i > want) ret.add(nums[i]);
            i = v;
        }
        int[] res = new int[ret.size()];
        for (int j =  0; j < ret.size(); j++) res[j] = ret.get(j);
        return res;
    }

    private int next(int[] nums, int v) {
        int hi = nums.length - 1;
        int lo = 0;
        while (lo < hi) {
            int mid = (lo + hi) >> 1;
            if (nums[mid] > v) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return nums[lo] > v ? lo : nums.length;
    }
}
