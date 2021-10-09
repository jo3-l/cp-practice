package binarysearch;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class GeneratePrimes {
    public int[] solve(int n) {
        if (n < 2) return new int[]{};

        BitSet isPrime = new BitSet(n + 1);
        isPrime.set(2, n + 1, true);
        for (int i = 2; i <= n; i++) {
            if (isPrime.get(i) && i * i <= n) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime.set(j, false);
                }
            }
        }
        List<Integer> primes = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            if (isPrime.get(i)) primes.add(i);
        }
        int[] ret = new int[primes.size()];
        for (int i = 0; i < primes.size(); i++) ret[i] = primes.get(i);
        return ret;
    }
}
