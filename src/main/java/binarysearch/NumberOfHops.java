package binarysearch;

public class NumberOfHops {
    public int solve(int[] nums) {
        int N = nums.length;
        if (N == 0) return 0;
        int[] dp = new int[N];
        SegTree st = new SegTree(N);
        dp[N - 1] = 0;
        for (int i = N - 2; i >= 0; i--) {
            int lo = i + 1;
            int hi = Math.min(nums[i] + i + 1, N); // exclusive
            int min = st.query(lo, hi);
            int r = min == Integer.MAX_VALUE ? min : min + 1;
            dp[i] = r;
            st.upd(i, r);
        }
        return dp[0];
    }

    private static class SegTree {
        private int[] data;
        private int N;

        public SegTree(int N) {
            this.data = new int[N << 1];
            this.N = N;
        }

        private void upd(int i, int v) {
            i += N;
            data[i] = v;
            for (; i > 1; i >>= 1) {
                data[i >> 1] = Math.min(data[i], data[i ^ 1]);
            }
        }

        private int query(int l, int r) {
            l += N;
            r += N;
            int res = Integer.MAX_VALUE;
            for (; l < r; l >>= 1, r >>= 1) {
                if ((l & 1) == 1) res = Math.min(res, data[l++]);
                if ((r & 1) == 1) res = Math.min(res, data[--r]);
            }
            return res;
        }
    }
}
