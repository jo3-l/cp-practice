package binarysearch;

import java.util.HashMap;
import java.util.Map;

public class EquivalentPairs {
    public int solve(int[] nums) {
        Map<Integer, Integer> oc = new HashMap<>();
        for (int num : nums) oc.merge(num, 1, Integer::sum);

        int n = 0;
        for (int o : oc.values()) {
            if (o > 1) n += (o * (o - 1)) >> 1;
        }

        return n;
    }
}
