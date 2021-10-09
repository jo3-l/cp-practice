package binarysearch;

public class OddPalindrome {
    public boolean solve(String s) {
        for (int l = 0, r = 1; r < s.length(); l++, r++) {
            if (s.charAt(l) == s.charAt(r)) return false;
        }
        return true;
    }
}
