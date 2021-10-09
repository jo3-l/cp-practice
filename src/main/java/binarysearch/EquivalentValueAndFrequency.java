package binarysearch;

import java.util.HashMap;
import java.util.Map;

public class EquivalentValueAndFrequency {
    public boolean solve(int[] nums) {
        Map<Integer, Integer> freqs = new HashMap<>();
        for (int num : nums) {
            freqs.merge(num, 1, Integer::sum);
        }

        for (Map.Entry<Integer, Integer> entry : freqs.entrySet()) {
            if (entry.getValue().equals(entry.getKey())) return true;
        }
        return false;
    }
}
