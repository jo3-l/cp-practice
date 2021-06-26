package binarysearch;

import java.util.Arrays;

public class StringIsomorphism {
    public boolean solve(String s, String t) {
        if (s.length() != t.length()) return false;

        int used = 0;
        int[] mapping = new int[26];
        Arrays.fill(mapping, -1);
        for (int i = 0; i < s.length(); i++) {
            int so = s.charAt(i) - 'a';
            int to = t.charAt(i) - 'a';
            if (mapping[so] == -1) {
                if ((used & (1 << to)) != 0) return false;
                mapping[so] = to;
                used |= 1 << to;
            } else if (mapping[so] != to) {
                return false;
            }
        }
        return true;
    }
}
