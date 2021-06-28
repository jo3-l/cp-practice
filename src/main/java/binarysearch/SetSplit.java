package binarysearch;

import java.util.Arrays;

public class SetSplit {
    public boolean solve(int[] nums) {
        if (nums.length == 0) return false;
        Arrays.sort(nums);
        int[] rs = new int[nums.length];
        rs[0] = nums[0];
        for (int i = 1; i < nums.length; i++) rs[i] = rs[i - 1] + nums[i];

        int[] ls = new int[nums.length];
        ls[nums.length - 1] = nums[nums.length - 1];
        for (int j = nums.length - 2; j >= 0; j--) ls[j] = ls[j + 1] + nums[j];

        for (int i = 0; i < nums.length - 1; i++) {
            if (rs[i] == ls[i + 1] && nums[i] != nums[i + 1]) {
                return true;
            }
        }
        return false;
    }
}
