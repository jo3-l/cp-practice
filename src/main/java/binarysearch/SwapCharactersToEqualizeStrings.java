package binarysearch;

public class SwapCharactersToEqualizeStrings {
    public boolean solve(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] sf = freq(s);
        int[] tf = freq(t);
        for (int i = 0; i < 26; i++) {
            if (((sf[i] + tf[i]) & 1) != 0) return false;
        }
        return true;
    }

    public int[] freq(String s) {
        int[] ret = new int[26];
        for (int i = 0; i < s.length(); i++) ret[s.charAt(i) - 'a']++;
        return ret;
    }
}
