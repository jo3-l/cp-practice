package binarysearch;

public class MinimumString {
    public int solve(String s, String t) {
        int[] fs = getF(s);
        int[] ts = getF(t);

        int getRid = 0;
        int wantAdd = 0;
        for (int i = 0; i < 26; i++) {
            if (ts[i] < fs[i]) getRid += fs[i] - ts[i];
            else if (ts[i] > fs[i]) wantAdd += ts[i] - fs[i];
        }

        return Math.abs(getRid - wantAdd) + Math.min(getRid, wantAdd);
    }

    private int[] getF(String s) {
        int[] r = new int[26];
        for (int i = 0; i < s.length(); i++) {
            r[s.charAt(i) - 'a']++;
        }
        return r;
    }
}
