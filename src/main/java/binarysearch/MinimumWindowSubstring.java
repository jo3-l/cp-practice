package binarysearch;

public class MinimumWindowSubstring {
    public int solve(String a, String b) {
        return solve(a, b, true);
    }

    public int solve(String a, String b, boolean recur) {
        int[] bFreq = new int[26];
        for (int i = 0; i < b.length(); i++) bFreq[b.charAt(i) - 'a']++;
        int[] aFreq = new int[26];
        int stillNeed = 0;
        int cantRemoveMore = (1 << 26) - 1;
        for (int i = 0; i < 26; i++) if (bFreq[i] != 0) stillNeed |= 1 << i;
        int i;
        for (i = 0; i < a.length(); i++) {
            int co = a.charAt(i) - 'a';
            aFreq[co]++;
            int bit = 1<<co;
            if ((stillNeed & bit) != 0) {
                if (bFreq[co] == aFreq[co]) {
                    stillNeed &= ~bit;
                }
            } else {
                cantRemoveMore &= ~bit;
            }
            if (stillNeed == 0) {
                break;
            }
        }
        if (stillNeed != 0) return -1;
        // we now know that a[0..i] (inclusive on upper) contains all of the characters of b.
        // now, let's try to minimize it by repeatedly chopping off prefixes of a[0..i]
        int j;
        for (j = 0; j < i; j++) {
            int co = a.charAt(j) - 'a';
            int bit = 1 << co;
            if ((cantRemoveMore & bit) != 0) break;
            if (--aFreq[co] == bFreq[co]) cantRemoveMore |= bit;
        }

        if (!recur) return i - j + 1;

        // try going in reverse
        char[] rv = new char[a.length()];
        for (int z = 0; z <= a.length() >> 1; z++) {
            rv[z] = a.charAt(a.length() - z - 1);
            rv[a.length() - z - 1] = a.charAt(z);
        }
        return Math.min(i - j + 1, solve(new String(rv), b, false));
    }
}
