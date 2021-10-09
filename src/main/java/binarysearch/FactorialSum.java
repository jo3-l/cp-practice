package binarysearch;

public class FactorialSum {
    public boolean solve(int n) {
        long[] fac = new long[13];
        for (int j = 1; j < 13; j++) fac[j] = cmp(j);
        for (int s = 0; s < (1 << 13); s++) {
            long r = 0;
            for (int j = 1; j < 13; j++) {
                if ((s & (1 << j)) != 0) r += fac[j];
            }
            if (n == r) return true;
        }
        return false;
    }

    private long cmp(int n) {
        long k = 1;
        for (int i = 2; i <= n; i++) k *= i;
        return k;
    }
}
