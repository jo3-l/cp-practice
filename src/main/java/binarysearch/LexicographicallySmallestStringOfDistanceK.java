package binarysearch;

public class LexicographicallySmallestStringOfDistanceK {
    public String solve(int n, int k) {
        char[] chars = new char[k];
        int available = n;
        for (int j = 0; j < k; j++) {
            int c = Math.max(available - (26 * (k - j - 1)), 1);
            chars[j] = (char) ('a' + c - 1);
            available -= c;
        }
        return new String(chars);
    }
}
