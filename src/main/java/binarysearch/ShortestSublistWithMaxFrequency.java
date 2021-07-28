package binarysearch;

import java.util.*;
import java.util.stream.Collectors;

public class ShortestSublistWithMaxFrequency {
    public int solve(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            freq.merge(nums[i], 1, Integer::sum);
        }

        List<Map.Entry<Integer, Integer>> sorted = freq.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toList());
        Set<Integer> mostFreq = new HashSet<>();
        mostFreq.add(sorted.get(sorted.size() - 1).getKey());
        int k = sorted.get(sorted.size() - 1).getValue();
        for (int i = sorted.size() - 2; i >= 0; i--) {
            if (sorted.get(i).getValue() == k) {
                mostFreq.add(sorted.get(i).getKey());
            } else {
                break;
            }
        }

        int min = Integer.MAX_VALUE;
        Map<Integer, List<Integer>> indices = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (mostFreq.contains(nums[i])) {
                List<Integer> appearances = indices.computeIfAbsent(nums[i], kk -> new ArrayList<>());
                appearances.add(i);
                if (appearances.size() == k) {
                    min = Math.min(min, i - appearances.get(0) + 1);
                }
            }
        }

        return min;
    }
}
