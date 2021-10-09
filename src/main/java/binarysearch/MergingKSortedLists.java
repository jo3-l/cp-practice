package binarysearch;

import java.util.Arrays;

public class MergingKSortedLists {
    public int[] solve(int[][] lists) {
        int l = 0;
        for (int[] ll : lists) l += ll.length;

        int[] vs = new int[l];
        int j = 0;
        for (int[] ll : lists) {
            for (int lll : ll) vs[j++] = lll;
        }

        Arrays.sort(vs);
        return vs;
    }
}