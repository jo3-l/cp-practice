package binarysearch;

public class PalindromicInteger {
    public boolean solve(int num) {
        String s = Integer.toString(num);
        for (int i = 0; i < s.length() >> 1; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) return false;
        }
        return true;
    }
}
