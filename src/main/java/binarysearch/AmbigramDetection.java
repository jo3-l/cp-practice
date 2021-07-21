package binarysearch;

public class AmbigramDetection {
    public boolean solve(String s, String[][] pairs) {
        int[] equalities = new int[26];
        for (int i = 0; i < 26; i++) {
            // Each character is equivalent to itself.
            equalities[i] = 1 << i;
        }

        for (String[] pair : pairs) {
            int c0 = pair[0].charAt(0) - 'a';
            int c1 = pair[1].charAt(0) - 'a';
            equalities[c0] |= 1 << c1;
            equalities[c1] |= 1 << c0;
        }

        boolean[] done = new boolean[26];
        for (int i = 0; i < 26; i++) resolveValue(i, equalities, 0, done);

        for (int i = 0; i < s.length() >> 1; i++) {
            int c0 = s.charAt(i) - 'a';
            int c1 = s.charAt(s.length() - i - 1) - 'a';
            if ((equalities[c0] & equalities[c1]) == 0) return false;
        }
        return true;
    }

    private void resolveValue(int n, int[] equalities, int seen, boolean[] done) {
        int val = equalities[n];
        if (done[n] || (seen & (1 << n)) != 0) return;

        for (int i = 0; i < 26; i++) {
            if ((val & (1 << i)) != 0) {
                resolveValue(i, equalities, seen | 1 << n, done);
                val |= equalities[i];
            }
        }

        done[n] = true;
        equalities[n] = val;
    }
}
