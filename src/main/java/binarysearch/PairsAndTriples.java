package binarysearch;

public class PairsAndTriples {
    public boolean solve(String s) {
        int[] ctr = new int[10];
        for (int i = 0; i < s.length(); i++) {
            ctr[s.charAt(i) - '0']++;
        }

        int N = 0;
        int nTwo = 0;
        int nTriples = 0;
        for (int elem : ctr) {
            if (elem == 0) continue;

            N++;
            int rem = elem % 3;
            nTriples++;
            if (rem == 2) nTwo++;
            else if (rem != 0) return false;
        }

        return nTwo == 1 && (nTriples == N || nTriples == N - 1);
    }
}
