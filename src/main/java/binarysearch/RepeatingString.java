package binarysearch;

public class RepeatingString {
    public boolean solve(String s) {
        if (s.length() < 2) return false;

        int n = s.length() >> 1;
        for (int i = 1; i <= n; i++) {
            if (check(s, i)) return true;
        }
        return false;
    }

    private boolean check(String s, int n) {
        if (s.length() % n != 0) return false;
        for (int i = 0; i < n; i++) {
            char f = s.charAt(i);
            for (int j = i + n; j < s.length(); j += n) {
                if (s.charAt(j) != f) return false;
            }
        }
        return true;
    }
}
