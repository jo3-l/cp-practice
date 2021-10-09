package binarysearch;

import java.util.HashMap;
import java.util.Map;

public class LongestZeroSublistSum {
    public int solve(int[] nums) {
        Map<Integer, Integer> mp = new HashMap<>();
        mp.put(0, -1);
        int s = 0;
        int n = 0;
        for (int i = 0; i < nums.length; i++) {
            s += nums[i];
            mp.putIfAbsent(s, i);
            int j = mp.get(s);
            n = Math.max(n, i - j);
        }
        return n;
    }
}
