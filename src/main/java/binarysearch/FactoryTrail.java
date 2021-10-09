package binarysearch;

public class FactoryTrail {
    public int solve(int n) {
        long f = 0;
        for (long d = 5; d <= n; d *= 5) f += n / d;
        long t = 0;
        for (long d = 2; d <= n; d <<= 1) t += n / d;
        return (int) Math.min(f, t);
    }
}
