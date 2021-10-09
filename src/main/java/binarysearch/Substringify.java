package binarysearch;

public class Substringify {
    public int solve(String big, String small) {
        int best = 101;
        for (int i = 0; i < big.length() - small.length() + 1; i++) {
            best = Math.min(best, diff(big.substring(i, i + small.length()), small));
        }
        return best == 101 ? 0 : best;
    }

    private int diff(String a, String b) {
        int ret = a.length();
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == b.charAt(i)) ret--;
        }
        return ret;
    }
}
