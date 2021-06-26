package binarysearch;

import java.util.ArrayList;
import java.util.List;

public class HitCounter {
    private List<Integer> ts = new ArrayList<>();

    public void add(int timestamp) {
        ts.add(timestamp);
    }

    public int count(int timestamp) {
        if (ts.isEmpty()) return 0;
        int min = timestamp - 60;

        int hi = ts.size() - 1;
        int lo = 0;
        // first value idx that is >= min
        while (lo < hi) {
            int mid = (lo + hi) >> 1;
            if (ts.get(mid) >= min) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        if (ts.get(lo) < min) return 0;
        return ts.size() - lo;
    }
}
