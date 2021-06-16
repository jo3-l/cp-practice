package binarysearch;

import java.util.Arrays;

public class AncientAstronautTheory {
    public boolean solve(String dictionary, String s) {
        int[] ps = new int[26];
        for (int i = 0; i < dictionary.length(); i++) {
            ps[dictionary.charAt(i) - 'a'] = i + 1;
        }

        int prev = Integer.MIN_VALUE;
        for (int i = 0; i < s.length(); i++) {
            int k = s.charAt(i) - 'a';
            if (k < 0 || ps[k] == 0) continue;
            int p = ps[k];
            if (p < prev) return false;
            prev = p;
        }

        return true;
    }
}
