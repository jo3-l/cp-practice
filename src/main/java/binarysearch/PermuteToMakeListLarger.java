package binarysearch;

import java.util.Arrays;

public class PermuteToMakeListLarger {
    public int solve(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        int n = 0;
        int i = 0;
        int j = 0;
        while (i < a.length && j < b.length) {
            if (a[i] > b[j]) {
                n++;
                j++;
            }
            i++;
        }
        return n;
    }
}
