package binarysearch;

import java.util.*;
import java.util.stream.Collectors;

public class SellingProducts {
    public int solve(int[] items, int n) {
        Map<Integer, Integer> freqs = new HashMap<>();
        for (int item : items) {
            freqs.merge(item, 1, Integer::sum);
        }

        List<Integer> sortedFreqs = freqs.values().stream().sorted().collect(Collectors.toList());

        int removed = 0;
        int diff = freqs.size();
        for (int v : sortedFreqs) {
            removed += v;
            if (removed <= n) diff--;
            else break;
        }

        return diff;
    }
}
