package binarysearch;

import java.util.HashMap;
import java.util.Map;

public class LongestPrefixThatIsASuffix {
    private final int BASE = 31;

    public String solve(String s) {
        if (s.length() < 2) return "";
        Map<Integer, Integer> suffixes = new HashMap<>();

        int suffixHash = 0;
        for (int i = s.length() - 1, pow = 1; i >= 1; i--, pow = pow * BASE) {
            suffixHash = s.charAt(i) * pow + suffixHash;
            suffixes.put(suffixHash, i);
        }

        int prefixHash = 0;
        int maxEnd = -1;
        for (int i = 0; i < s.length() - 1; i++) {
            prefixHash = prefixHash * BASE + s.charAt(i);
            Integer start = suffixes.get(prefixHash);
            if (start != null) {
                if (s.substring(start).equals(s.substring(0, i + 1))) maxEnd = i + 1;
            }
        }

        return maxEnd == -1 ? "" : s.substring(0, maxEnd);
    }
}
