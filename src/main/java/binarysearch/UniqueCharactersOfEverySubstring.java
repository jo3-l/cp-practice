package binarysearch;

import java.util.ArrayList;
import java.util.List;

public class UniqueCharactersOfEverySubstring {
    public int solve(String s) {
        final long MOD = (long) 1e9 + 7;
        @SuppressWarnings("unchecked")
        List<Integer>[] locs = new ArrayList[26];
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            if (locs[c] == null) locs[c] = new ArrayList<>();
            locs[c].add(i);
        }
        int[] cur = new int[26];
        long res = 0;
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            int pos = cur[c];
            List<Integer> idxs = locs[c];
            if (pos == 0) {
                int next = idxs.size() == 1 ? s.length() : idxs.get(pos + 1);
                // the current character is unique in all substrings starting between
                // [0, i] and ending between [i, next).
                res += (long) (i + 1) * (next - i);
            } else if (pos < idxs.size() - 1) {
                int prev = idxs.get(pos - 1);
                int next = idxs.get(pos + 1);
                // the current character is unique in all substrings starting between
                // (prev, i] and ending between [i, next)
                res += (long) (i - prev) * (next - i);
            } else {
                int prev = idxs.get(pos - 1);
                // the current character is unique in all substrings starting between
                // (prev, i] and ending between [i, |s|)
                res += (long) (i - prev) * (s.length() - i);
            }

            res %= MOD;
            cur[c]++;
        }

        return (int) (res % MOD);
    }
}
