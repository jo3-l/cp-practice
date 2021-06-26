package binarysearch;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SortByFrequencyAndValue {
    public int[] solve(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) freq.merge(num, 1, Integer::sum);

        List<Map.Entry<Integer, Integer>> entries = freq.entrySet()
                .stream()
                .sorted(Comparator.comparing((Function<Map.Entry<Integer, Integer>, Integer>) Map.Entry::getValue)
                        .thenComparing(Map.Entry::getKey)
                        .reversed())
                .collect(Collectors.toList());
        int[] ret = new int[nums.length];
        int j = 0;
        for (Map.Entry<Integer, Integer> e : entries) {
            for (int i = 0; i < e.getValue(); i++) ret[j++] = e.getKey();
        }
        return ret;
    }
}
