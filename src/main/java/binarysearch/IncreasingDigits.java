package binarysearch;

public class IncreasingDigits {
    public int solve(int n) {
        return go(n, 9);
    }

    private int go(int n, int ending) {
        if (n == 0) return 0;
        if (n == 1) return ending;
        int ctr = 0;
        for (int e = 1; e < ending; e++) ctr += go(n - 1, e);
        return ctr;
    }
}
