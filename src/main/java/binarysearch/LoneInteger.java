package binarysearch;

import java.util.HashMap;
import java.util.Map;

public class LoneInteger {
    public int solve(int[] nums) {
        Map<Integer, Integer> mp = new HashMap<>();
        for (int v : nums) mp.merge(v, 1, Integer::sum);
        for (Map.Entry<Integer, Integer> e : mp.entrySet()) {
            if (e.getValue() == 1) return e.getKey();
        }
        return -1;
    }
}
