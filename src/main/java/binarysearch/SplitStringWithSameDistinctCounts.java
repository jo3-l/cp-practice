package binarysearch;

public class SplitStringWithSameDistinctCounts {
    public int solve(String s) {
        int[] ld = new int[26];
        int lc = 0;
        int[] rd = new int[26];
        int rc = 0;
        for (int i = 0; i < s.length(); i++) {
            if (rd[s.charAt(i) - 'a']++ == 0) rc++;
        }

        int n = 0;
        for (int i = 0; i < s.length(); i++) {
            if (ld[s.charAt(i) - 'a']++ == 0) lc++;
            if (--rd[s.charAt(i) - 'a'] == 0) rc--;
            if (lc == rc) n++;
        }
        return n;
    }
}
