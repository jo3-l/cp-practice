package binarysearch;

public class Robinhood {
    public int solve(int n, int e, int o, int t) {
        double[] ms = new double[]{1 + ((double) e / 100), 1 + ((double) o / 100)};
        double cur = n;
        int years = 0;
        while (cur < t) cur *= ms[years++ & 1];
        return years;
    }
}
