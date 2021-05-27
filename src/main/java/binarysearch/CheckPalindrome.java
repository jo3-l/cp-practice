package binarysearch;

public class CheckPalindrome {
    public boolean solve(String s) {
        int mid = s.length() >> 1;
        for (int i = 0; i < mid; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) return false;
        }
        return true;
    }
}
