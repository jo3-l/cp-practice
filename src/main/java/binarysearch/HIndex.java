package binarysearch;

import java.util.Arrays;

public class HIndex {
    public int solve(int[] citations) {
        Arrays.sort(citations);
        int best = 0;
        for (int i = citations.length - 1; i >= 0; i--) {
            int h = citations.length - i;
            if (citations[i] >= h) best = Math.max(best, h);
        }
        return best;
    }
}
