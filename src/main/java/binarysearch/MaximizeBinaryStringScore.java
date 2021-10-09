package binarysearch;

public class MaximizeBinaryStringScore {
    public int solve(String s) {
        int[] oneDp = new int[s.length()]; // V in {0...n-1} => number of 1s from V..end, inclusive
        oneDp[s.length() - 1] = s.charAt(s.length() - 1) == '1' ? 1 : 0;
        int[] zeroDp = new int[s.length()]; // V in {0...n-1} => number of 0s from 0..V, inclusive
        zeroDp[0] = s.charAt(0) == '0' ? 1 : 0;
        for (int i = 1; i < s.length(); i++) {
            int contrib0 = s.charAt(i) == '0' ? 1 : 0;
            zeroDp[i] = zeroDp[i - 1] + contrib0;

            int i1 = s.length() - i - 1;
            int contrib1 = s.charAt(i1) == '1' ? 1 : 0;
            oneDp[i1] = oneDp[i1 + 1] + contrib1;
        }

        int max = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            max = Math.max(max, zeroDp[i] + oneDp[i + 1]);
        }

        return max;
    }
}
