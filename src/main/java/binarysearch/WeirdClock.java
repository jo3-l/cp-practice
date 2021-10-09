package binarysearch;

public class WeirdClock {
    public String solve(String s) {
        int[] choices = {s.charAt(0) - '0', s.charAt(1) - '0', s.charAt(3) - '0', s.charAt(4) - '0'};
        int v = cmp(choices[0], choices[1], choices[2], choices[3]);
        int closest = (int) 1e9;
        for (int a = 0; a < 4; a++) {
            for (int b = 0; b < 4; b++) {
                for (int c = 0; c < 4; c++) {
                    for (int d = 0; d < 4; d++) {
                        if (a == 0 && b == 1 && c == 2 && d == 3) continue;
                        if (!isValid(choices[a], choices[b], choices[c], choices[d])) continue;
                        int cur = cmp(choices[a], choices[b], choices[c], choices[d]);
                        if (dist(cur, v) < dist(closest, v)) closest = cur;
                    }
                }
            }
        }
        return show(closest);
    }

    private boolean isValid(int h0, int h1, int m0, int m1) {
        return (h0 < 2 || (h0 == 2 && h1 <= 3)) && m0 < 6;
    }

    private int cmp(int h0, int h1, int m0, int m1) {
        int h = h0 * 10 + h1;
        int m = m0 * 10 + m1;
        return h * 60 + m;
    }

    private int dist(int a, int b) {
        if (a <= b) a += 24 * 60;
        return a - b;
    }

    private String show(int x) {
        int hours = x / 60;
        int minutes = x % 60;
        return (hours < 10 ? "0" + hours : Integer.toString(hours)) + ":" + (minutes < 10 ? "0" + minutes : Integer.toString(minutes));
    }
}
