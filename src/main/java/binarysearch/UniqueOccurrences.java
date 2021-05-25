package binarysearch;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class UniqueOccurrences {
    public boolean solve(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : nums) {
            counts.merge(num, 1, Integer::sum);
        }

        HashSet<Integer> seen = new HashSet<>(counts.values());
        return seen.size() == counts.size();
    }
}
