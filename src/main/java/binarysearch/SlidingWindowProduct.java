package binarysearch;

import java.util.ArrayList;
import java.util.List;

public class SlidingWindowProduct {
    private int lastZero = -1;
    private List<Integer> ps = new ArrayList<>();

    public void add(int num) {
        int last = ps.isEmpty() ? 1 : ps.get(ps.size() - 1);
        if (num == 0) {
            ps.add(last);
            lastZero = ps.size() - 1;
        } else {
            ps.add(num * last);
        }
    }

    public int product(int k) {
        int hi = ps.size() - 1;
        int lo = ps.size() - k - 1;
        if (lastZero != -1 && (lo < lastZero && lastZero <= hi)) return 0;
        int x = ps.get(hi);
        int y = lo >= 0 ? ps.get(lo) : 1;
        return x / y;
    }
}
