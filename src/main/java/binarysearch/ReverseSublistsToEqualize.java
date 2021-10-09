package binarysearch;

import java.util.HashMap;
import java.util.Map;

public class ReverseSublistsToEqualize {
    public boolean solve(int[] nums, int[] target) {
        Map<Integer, Integer> f0 = getFrequencies(nums);
        Map<Integer, Integer> f1 = getFrequencies(target);
        for (Map.Entry<Integer, Integer> e : f0.entrySet()) {
            Integer ov = f1.get(e.getKey());
            if (ov == null) return false;
            if (!ov.equals(e.getValue())) return false;
         }
        return true;
    }

    private Map<Integer, Integer> getFrequencies(int[] nums) {
        Map<Integer, Integer> res = new HashMap<>();
        for (int num : nums) res.merge(num, 1, Integer::sum);
        return res;
    }
}
