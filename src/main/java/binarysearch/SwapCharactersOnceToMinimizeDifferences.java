package binarysearch;

public class SwapCharactersOnceToMinimizeDifferences {
    public int solve(String s, String t) {
        int[] mismatch = new int[26];
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            int sc = s.charAt(i) - 'a';
            int tc = t.charAt(i) - 'a';
            if (sc != tc) {
                mismatch[sc] |= 1 << tc;
                cnt++;
            }
        }

        boolean goodSwap = false;
        for (int i = 0; i < 26; i++) {
            if (mismatch[i] == 0) continue;
            int bit = 1 << i;
            for (int j = 0; j < 26; j++) {
                if ((mismatch[i] & (1 << j)) != 0) {
                    if ((mismatch[j] & bit) != 0) return cnt - 2; // can swap 2 to make both match
                }
                if (i != j && (mismatch[j] & bit) != 0) goodSwap = true;
            }
        }
        return cnt - (goodSwap ? 1 : 0);
    }
}
