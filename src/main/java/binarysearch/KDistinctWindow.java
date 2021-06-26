package binarysearch;

import java.util.HashMap;
import java.util.Map;

public class KDistinctWindow {
    public int[] solve(int[] nums, int k) {
        Map<Integer, Integer> frequencies = new HashMap<>();
        int[] res = new int[nums.length - k + 1];
        for (int i = 0, j = k - 1; j < nums.length; i++, j++) {
            if (i == 0) {
                for (int z = 0; z <= j; z++) frequencies.merge(nums[z], 1, Integer::sum);
                res[0] = frequencies.size();
                continue;
            }

            if (frequencies.merge(nums[i - 1], -1, Integer::sum) == 0) {
                frequencies.remove(nums[i - 1]);
            }
            frequencies.merge(nums[j], 1, Integer::sum);
            res[i] = frequencies.size();
        }
        return res;
    }
}