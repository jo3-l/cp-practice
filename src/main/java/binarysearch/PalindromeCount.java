package binarysearch;

import java.util.HashSet;
import java.util.Set;

public class PalindromeCount {
    public int solve(String s, int k) {
        Set<Character> hs = new HashSet<>();
        for (int i = 0; i < s.length(); i++) hs.add(s.charAt(i));
        int n = hs.size();
        int r = 1;
        for (int i = 0; i < (k + 1) >> 1; i++) r *= n;
        return r;
    }
}
