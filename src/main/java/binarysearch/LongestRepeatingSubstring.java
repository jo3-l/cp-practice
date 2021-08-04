package binarysearch;

import java.util.HashSet;
import java.util.Set;

public class LongestRepeatingSubstring {
    public int solve(String s) {
        for (int len = s.length() - 1; len >= 1; len--) {
            if (find(s, len)) return len;
        }
        return 0;
    }

    private boolean find(String s, int len) {
        final int P = 31;
        // initial window of characters
        int hsh = 0;
        int maxP = 1;
        for (int i = 0; i < len; i++) {
            hsh = (hsh * P) + s.charAt(i);
            if (i > 0) maxP *= P;
        }
        Set<Integer> seen = new HashSet<>();
        seen.add(hsh);
        for (int i = 1, j = len; j < s.length(); i++, j++) {
            hsh = (hsh - maxP * s.charAt(i - 1)) * P + s.charAt(j);
            if (!seen.add(hsh)) return true; // found same substring twice
        }
        return false;
    }
}
