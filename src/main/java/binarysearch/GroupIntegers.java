package binarysearch;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class GroupIntegers {
    public boolean solve(int[] nums) {
        Map<Integer, Integer> freqs = new HashMap<>();
        for (int num : nums) {
            freqs.merge(num, 1, Integer::sum);
        }

        Iterator<Map.Entry<Integer, Integer>> iter = freqs.entrySet().iterator();
        int v = iter.next().getValue();
        if (v < 2) return false;
        while (iter.hasNext()) v = gcd(v, iter.next().getValue());
        return v >= 2;
    }

    private int gcd(int a, int b) {
        while (b > 0) {
            int tmp = b;
            b = a % b;
            a = tmp;
        }
        return a;
    }
}
