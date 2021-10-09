package binarysearch;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class HighFrequency {
    public int solve(int[] nums) {
        if (nums.length == 0) return 0;

        Map<Integer, Integer> freqs = new HashMap<>();
        for (int num : nums) {
            freqs.merge(num, 1, Integer::sum);
        }

        return Collections.max(freqs.values());
    }
}
