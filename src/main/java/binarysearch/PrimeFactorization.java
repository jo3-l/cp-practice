package binarysearch;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactorization {
    public int[] solve(int n) {
        if (n == 0) return new int[0];

        List<Integer> res = new ArrayList<>();
        if ((n & 1) == 0) {
            while ((n & 1) == 0) {
                n >>= 1;
                res.add(2);
            }
        }
        for (int j = 3; j < Math.sqrt(n) + 1; j += 2) {
            if (n % j != 0 || !isPrime(j)) continue;
            while (n % j == 0) {
                n /= j;
                res.add(j);
            }
        }

        if (n != 1 && isPrime(n)) res.add(n);

        int[] ret = new int[res.size()];
        for (int i = 0; i < res.size(); i++) ret[i] = res.get(i);
        return ret;
    }

    private boolean isPrime(int n) {
        if (n == 2) return true;
        if ((n & 1) == 0) return false;
        for (int j = 3; j < Math.sqrt(n) + 1; j += 2) {
            if (n % j == 0) return false;
        }
        return true;
    }
}
