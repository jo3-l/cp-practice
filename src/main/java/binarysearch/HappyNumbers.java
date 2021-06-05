package binarysearch;

import java.util.HashSet;
import java.util.Set;

public class HappyNumbers {
    public boolean solve(int n) {
        Set<Integer> seen = new HashSet<>();
        int v = run(n);
        while (v != 1) {
            v = run(v);
            if (!seen.add(v)) return false;
        }
        return true;
    }

    public int run(int n) {
        int d = (int) Math.pow(10, (int) Math.log10(n));
        int x = 0;
        while (d > 1) {
            int digit = n / d;
            x += digit * digit;
            n -= digit * d;
            d /= 10;
        }

        return x + (n * n);
    }
}
