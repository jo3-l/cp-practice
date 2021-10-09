package binarysearch;

public class UglyNumber {
    public boolean solve(int n) {
        if (n == 0) return false;
        if (n <= 5) return true;
        for (int i = 2; i < Math.sqrt(n) + 1; i++) {
            if (n % i != 0) continue;
            if (isPrime(i) && i > 5) return false;
            int other = n / i;
            if (isPrime(other) && other > 5) return false;
        }
        return !isPrime(n);
    }

    private boolean isPrime(int n) {
        if (n < 2) return true;
        if ((n & 1) == 0) return false;
        for (int i = 3; i < Math.sqrt(n) + 1; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
