package binarysearch;

public class MergingTwoSortedLists {
    public int[] solve(int[] a, int [] b) {
        int[] sorted = new int[a.length + b.length];
        int cur = 0;

        int i = 0;
        int j = 0;
        while (i < a.length || j < b.length) {
            if (i < a.length && j < b.length) {
                int av = a[i];
                int bv = b[j];
                if (av <= bv) {
                    sorted[cur++] = av;
                    i++;
                } else {
                    sorted[cur++] = bv;
                    j++;
                }
            } else {
                if (i != a.length) sorted[cur++] = a[i++];
                else sorted[cur++] = b[j++];
            }
        }
        return sorted;
    }
}
