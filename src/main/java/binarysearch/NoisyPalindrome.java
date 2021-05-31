package binarysearch;

public class NoisyPalindrome {
    public boolean solve(String s) {
        StringBuilder f = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ('a' <= c && c <= 'z') f.append(c);
        }

        for (int i = 0; i < f.length() >> 1; i++) {
            if (f.charAt(i) != f.charAt(f.length() - i - 1)) return false;
        }
        return true;
    }
}
