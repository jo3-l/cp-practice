package binarysearch;

import java.util.Arrays;

public class KUniqueString {
    public int solve(String s, int k) {
        int[] counts = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            counts[c - 'a']++;
        }

        Arrays.sort(counts);

        int i;
        for (i = 0; i < counts.length; i++) {
            if (counts[i] != 0) break;
        }

        int numUniq = counts.length - i;

        int n = 0;
        for (int j = 0; j < numUniq - k; j++) {
            n += counts[i + j];
        }

        return n;
    }
}
