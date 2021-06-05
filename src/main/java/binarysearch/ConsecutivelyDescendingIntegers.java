package binarysearch;

public class ConsecutivelyDescendingIntegers {
    public boolean solve(String s) {
        return check(s, 0, -1, 0);
    }

    private boolean check(String s, int i, int last, int n) {
        if (i == s.length()) return n > 1;
        int begin = i;
        for (; i < s.length(); i++) {
            String v = s.substring(begin, i + 1);
            int x = Integer.parseInt(v);
            if (last != -1 && x != last - 1) continue;
            if (check(s, i + 1, x, n + 1)) return true;
        }

        return false;
    }
}
