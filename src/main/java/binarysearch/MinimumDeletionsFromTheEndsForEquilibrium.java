package binarysearch;

import java.util.HashMap;
import java.util.Map;

public class MinimumDeletionsFromTheEndsForEquilibrium {
    public int solve(int[] nums) {
        if (nums.length == 0) return 0;
        Map<Integer, Integer> mp = new HashMap<>();
        mp.put(0, -1);
        int s = 0;
        int l = 0;
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            if (n == 1) s++;
            else s--;
            mp.putIfAbsent(s, i);
            l = Math.max(l, i - mp.get(s));
        }
        return nums.length - l;
    }
}
