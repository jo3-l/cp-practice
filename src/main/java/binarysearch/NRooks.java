package binarysearch;

public class NRooks {
    public int solve(int n) {
        int f = 1;
        for (int i = 2; i <= n; i++) f *= i;
        return f;
    }
}
