package binarysearch;

public class StringEquivalenceRelations {
    public String solve(String a, String b, String target) {
        int[] equalities = new int[26];
        for (int i = 0; i < 26; i++) {
            equalities[i] |= 1 << i;
        }

        for (int i = 0; i < a.length(); i++) {
            int c0 = a.charAt(i) - 'a';
            int c1 = b.charAt(i) - 'a';
            equalities[c0] |= 1 << c1;
            equalities[c1] |= 1 << c0;
        }

        boolean[] done = new boolean[26];
        for (int i = 0; i < 26; i++) resolveValue(i, equalities, 0, done);

        char[] ret = new char[target.length()];
        for (int i = 0; i < target.length(); i++) {
            int c = target.charAt(i) - 'a';
            int lo = Integer.numberOfTrailingZeros(equalities[c]);
            ret[i] = (char) (lo + 'a');
        }
        return new String(ret);
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
