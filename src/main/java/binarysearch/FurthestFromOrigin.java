package binarysearch;

public class FurthestFromOrigin {
    public int solve(String s) {
        int n = 0;
        int wildcardCtr = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'L') n--;
            else if (c == 'R') n++;
            else wildcardCtr++;
        }

        if (n < 0) n -= wildcardCtr;
        else n += wildcardCtr;
        return Math.abs(n);
    }
}
