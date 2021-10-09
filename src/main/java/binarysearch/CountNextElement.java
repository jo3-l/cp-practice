package binarysearch;

import java.util.HashMap;
import java.util.Map;

public class CountNextElement {
    public int solve(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.merge(num, 1, Integer::sum);
        }

        int n = 0;
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            int x = entry.getKey();
            int occ = entry.getValue();
            if (freq.containsKey(x + 1)) n += occ;
        }
        return n;
    }
}
