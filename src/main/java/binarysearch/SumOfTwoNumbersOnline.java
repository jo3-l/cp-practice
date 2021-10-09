package binarysearch;

import java.util.HashMap;
import java.util.Map;

public class SumOfTwoNumbersOnline {
    private Map<Integer, Integer> vs = new HashMap<>();

    public void add(int val) {
        vs.merge(val, 1, Integer::sum);
    }

    public boolean find(int val) {
        for (Map.Entry<Integer, Integer> e : vs.entrySet()) {
            int other = val - e.getKey();
            if (
                    (other == e.getKey() && e.getValue() > 1)
                    || (other != e.getKey() && vs.containsKey(other))
            ) return true;
        }
        return false;
    }
}
