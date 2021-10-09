package binarysearch;

public class RookieMistake {
    public boolean solve(String s) {
        boolean leftBlocked = false;
        boolean rightBlocked = false;

        int idx = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'B' && idx == -1) {
                leftBlocked = true;
            } else if (c == 'R') {
                idx = i;
            } else if (c == 'B') {
                rightBlocked = true;
            }
        }
        return !leftBlocked || !rightBlocked;
    }
}
