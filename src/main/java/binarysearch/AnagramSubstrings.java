package binarysearch;

public class AnagramSubstrings {
    // xor this to see if all are eq
    private final int allEqMask = 0b11111111111111111111111111;

    public int solve(String s0, String s1) {
        if (s1.length() < s0.length()) return 0;
        int[] wantFreq = new int[26];
        computeFreq(s0, wantFreq);

        int count = 0;

        int[] windowFreq = new int[26];
        int same = 0;
        for (int i = 0, j = s0.length() - 1; j < s1.length(); i++, j++) {
            if (i == 0) {
                computeFreq(s1.substring(i, j + 1), windowFreq);
                for (int z = 0; z < 26; z++) {
                    if (wantFreq[z] == windowFreq[z]) same |= 1 << z;
                }
                if ((same ^ allEqMask) == 0) count++;
                continue;
            }

            int discard = s1.charAt(i - 1) - 'a';
            if (--windowFreq[discard] != wantFreq[discard]) same &= ~(1 << discard); // unset bit
            else same |= 1 << discard;

            int add = s1.charAt(j) - 'a';
            if (++windowFreq[add] != wantFreq[add]) same &= ~(1 << add); // unset bit
            else same |= 1 << add;
            if ((same ^ allEqMask) == 0) count++;
        }

        return count;
    }

    private void computeFreq(String s, int[] buf) {
        for (int i = 0; i < s.length(); i++) {
            buf[s.charAt(i) - 'a']++;
        }
    }
}
