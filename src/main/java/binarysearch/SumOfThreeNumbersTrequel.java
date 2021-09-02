package binarysearch;

public class SumOfThreeNumbersTrequel {
    public int solve(int[] nums) {
        SegTree st = new SegTree(nums);
        int ans = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length - 1; i++) {
            int pre = st.queryMaxLte(0, i, nums[i]);
            if (pre == Integer.MAX_VALUE) continue;
            int post = st.queryMax(i + 1, nums.length);
            if (post < nums[i]) continue;
            ans = Math.max(ans, nums[i] + pre + post);
        }
        return ans;
    }

    private static class SegTree {
        private int[][] data;
        private int len;

        public SegTree(int[] xs) {
            len = xs.length;
            data = new int[len << 1][];
            build(xs);
        }

        // max on [l, r)
        public int queryMax(int l, int r) {
            l += len;
            r += len;
            int res = Integer.MIN_VALUE;
            while (l < r) {
                if ((l & 1) == 1) {
                    int[] a = data[l++];
                    res = Math.max(res, a[a.length - 1]);
                }
                if ((r & 1) == 1) {
                    int[] a = data[--r];
                    res = Math.max(res, a[a.length - 1]);
                }

                l >>= 1;
                r >>= 1;
            }
            return res;
        }

        // maximum value that is <= n on [l, r)
        private int queryMaxLte(int l, int r, int n) {
            l += len;
            r += len;
            int res = Integer.MIN_VALUE;
            while (l < r) {
                if ((l & 1) == 1) {
                    int[] a = data[l++];
                    int i = findLastLte(a, n);
                    if (i != -1) res = Math.max(res, a[i]);
                }
                if ((r & 1) == 1) {
                    int[] a = data[--r];
                    int i = findLastLte(a, n);
                    if (i != -1) res = Math.max(res, a[i]);
                }

                l >>= 1;
                r >>= 1;
            }

            return res;
        }

        private int findLastLte(int[] a, int n) {
            int lo = 0;
            int hi = a.length - 1;
            while (lo < hi) {
                int mid = (lo + hi + 1) >>> 1;
                if (a[mid] <= n) lo = mid;
                else hi = mid - 1;
            }
            return a[lo] <= n ? lo : -1;
        }

        private void build(int[] xs) {
            for (int i = 0; i < len; i++) {
                data[i + len] = new int[]{xs[i]};
            }

            for (int i = len - 1; i > 0; i--) {
                data[i] = merge(data[i << 1], data[i << 1 | 1]);
            }
        }

        private int[] merge(int[] a, int[] b) {
            int[] res = new int[a.length + b.length];
            int i = 0;
            int j = 0;
            int k = 0;
            while (i < a.length || j < b.length) {
                boolean chooseA = j >= b.length || (i < a.length && a[i] < b[j]);
                res[k++] = chooseA ? a[i++] : b[j++];
            }
            return res;
        }
    }
}
