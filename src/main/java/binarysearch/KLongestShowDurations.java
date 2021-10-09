package binarysearch;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class KLongestShowDurations {
    public int solve(String[] shows, int[] durations, int k) {
        Map<String, Integer> watched = new HashMap<>();
        for (int i = 0; i < shows.length; i++) {
            watched.merge(shows[i], durations[i], Integer::sum);
        }

        return watched.values()
                .stream()
                .sorted(Comparator.reverseOrder())
                .limit(k)
                .mapToInt(Integer::intValue)
                .sum();
    }
}
