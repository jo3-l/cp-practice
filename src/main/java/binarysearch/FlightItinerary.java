package binarysearch;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FlightItinerary {
    public String[] solve(String[][] flights) {
        Map<String, String> next = new HashMap<>();
        Set<String> all = new HashSet<>();
        for (String[] f : flights) {
            all.add(f[0]);
            all.add(f[1]);
            next.put(f[0], f[1]);
        }

        for (String[] f : flights) all.remove(f[1]);

        String start = all.iterator().next();
        String[] ret = new String[flights.length + 1];
        int j = 0;
        for (String cur = start; cur != null; cur = next.get(cur)) ret[j++] = cur;
        return ret;
    }
}
