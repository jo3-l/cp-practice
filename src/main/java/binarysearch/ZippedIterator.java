package binarysearch;

public class ZippedIterator {
    private int[][] elem;
    private int n;
    private int m = 0;

    public ZippedIterator(int[] a, int[] b) {
        if (a.length == 0) {
            int[] tmp = a;
            a = b;
            b = tmp;
        }
        elem = new int[][]{a, b};
    }

    public int next() {
        int v = elem[m][n];
        if (elem[m ^ 1].length > n + m) {
            n += m;
            m ^= 1;
        } else {
            n++;
        }
        return v;
    }

    public boolean hasnext() {
        return elem[m].length > n;
    }
}
