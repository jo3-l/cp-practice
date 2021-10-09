package binarysearch;

import java.util.HashMap;
import java.util.Map;

public class RepeatedKLengthSubstrings {
    public int solve(String s, int k) {
        Map<String, Boolean> m = new HashMap<>();
        for (int i = 0, j = k - 1; j < s.length(); i++, j++) {
            String v = s.substring(i, j + 1);
            m.merge(v, false, (kk, vv) -> true);
        }

        int r = 0;
        for (boolean b : m.values()) if (b) r++;
        return r;
    }
}
