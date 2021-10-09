package binarysearch;

public class LongDistance {
    public int[] solve(int[] lst) {
        SegTree st = new SegTree(lst);
        for (int i = 0; i < lst.length; i++) {
            lst[i] = st.query(i + 1, lst.length, lst[i]);
        }
        return lst;
    }

    public static class SegTree {
        private int[][] data;
        private int len;

        public SegTree(int[] arr) {
            len = arr.length;
            data = new int[arr.length * 2][];
            init(arr);
        }

        public int query(int l, int r, int n) {
            int result = 0;
            l += len;
            r += len;
            while (l < r) {
                if ((l & 1) == 1) {
                    result += findLastIdxLessThan(data[l++], n) + 1;
                }
                if ((r & 1) == 1) {
                    result += findLastIdxLessThan(data[--r], n) + 1;
                }

                l >>= 1;
                r >>= 1;
            }
            return result;
        }

        private void init(int[] arr) {
            for (int i = 0; i < arr.length; i++) {
                data[i + len] = new int[]{arr[i]};
            }
            for (int i = len - 1; i > 0; i--) {
                data[i] = mergeSortedLists(data[i << 1], data[i << 1 | 1]);
            }
        }

        private int findLastIdxLessThan(int[] arr, int n) {
            int lo = 0;
            int hi = arr.length - 1;
            while (lo < hi) {
                int mid = (lo + hi + 1) >> 1;
                if (arr[mid] < n) {
                    lo = mid;
                } else {
                    hi = mid - 1;
                }
            }
            return arr[lo] < n ? lo : -1;
        }

        private int[] mergeSortedLists(int[] a, int[] b) {
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
}
