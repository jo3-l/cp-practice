package binarysearch;

public class PalindromeSplitting {
    public int solve(String s) {
        if (s.length() < 2) return 1;
        int res = 0;
        for (int i = 0; i < 1 << (s.length() - 1); i++) {
            if (check(s, i)) res++;
        }
        return res;
    }

    private boolean check(String s, int p) {
        if (p == 0) return isPalindrome(s, 0, s.length() - 1);
        int start = 0;
        for (int i = 1; i < s.length(); i++) {
            if ((p & (1 << (i - 1))) != 0) {
                if (!isPalindrome(s, start, i - 1)) return false;
                start = i;
            }
        }
        return isPalindrome(s, start, s.length() - 1);
    }

    private boolean isPalindrome(String s, int i, int j) {
        while (i <= j) {
            if (s.charAt(i++) != s.charAt(j--)) return false;
        }
        return true;
    }
}
