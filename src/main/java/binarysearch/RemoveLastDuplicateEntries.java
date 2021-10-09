package binarysearch;

import java.util.*;

public class RemoveLastDuplicateEntries {
    public int[] solve(int[] nums) {
        if (nums.length < 2) return nums;

        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) freq.merge(num, 1, Integer::sum);

        List<Integer> ret = new ArrayList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            int num = nums[i];
            if (freq.getOrDefault(num, 0) > 1) freq.put(num, 0);
            else ret.add(num);
        }

        int[] res = new int[ret.size()];
        for (int i = 0; i <= ret.size() >> 1; i++) {
            res[i] = ret.get(ret.size() - i - 1);
            res[ret.size() - i - 1] = ret.get(i);
        }
        return res;
    }
}
