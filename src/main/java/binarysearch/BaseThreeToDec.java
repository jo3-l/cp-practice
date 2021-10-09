package binarysearch;

public class BaseThreeToDec {
    public int solve(String s) {
        int multiplier = 1;
        int n = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            int v = s.charAt(i) - '0';
            n += v * multiplier;
            multiplier *= 3;
        }

        return n;
    }
}
