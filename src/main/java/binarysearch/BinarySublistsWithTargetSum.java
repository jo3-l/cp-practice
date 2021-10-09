package binarysearch;

import java.util.HashMap;
import java.util.Map;

public class BinarySublistsWithTargetSum {
    public int solve(int[] nums, int target) {
        Map<Integer, Integer> fre = new HashMap<>();
        fre.put(0, 1);
        int s = 0;
        int ans = 0;
        for (int n : nums) {
            s += n;
            ans += fre.getOrDefault(s - target, 0);
            fre.merge(s, 1, Integer::sum);
        }
        return ans;
    }
}
