package binarysearch;

public class AUniqueString {
    public boolean solve(String s) {
        if (s.length() > 26) return false;

        int seen = 0;
        for (int i = 0; i < s.length(); i++) {
            int j = s.charAt(i) - 'a';
            int bit = 1 << j;
            if ((seen & bit) != 0) return false;
            seen |= bit;
        }

        return true;
    }
}
