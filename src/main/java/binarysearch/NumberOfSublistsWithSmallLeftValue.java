package binarysearch;

public class NumberOfSublistsWithSmallLeftValue {
    public int solve(int[] nums) {
        if (nums.length == 0) return 0;
        SparseTable st = new SparseTable(nums);
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == nums.length - 1) {
                res++;
                continue;
            }

            int lo = i + 1;
            int hi = nums.length - 1;
            while (lo < hi) {
                int mid = (lo + hi + 1) >>> 1;
                if (st.query(i, mid) >= nums[i]) lo = mid;
                else hi = mid - 1;
            }
            res += st.query(i, lo) >= nums[i]
                    ? lo - i + 1
                    : 1;
        }
        return res;
    }

    private static class SparseTable {
        private int[][] t;

        public SparseTable(int[] nums) {
            t = new int[nums.length][33 - Integer.numberOfLeadingZeros(nums.length - 1)];
            build(nums);
        }

        // min on [i, j]
        public int query(int i, int j) {
            int k = 31 - Integer.numberOfLeadingZeros(j - i + 1);
            return Math.min(t[i][k], t[j - (1 << k) + 1][k]);
        }

        private void build(int[] nums) {
            for (int i = 0; i < nums.length; i++) t[i][0] = nums[i];
            for (int k = 1; k <= 32 - Integer.numberOfLeadingZeros(nums.length - 1); k++) {
                for (int i = 0; i + (1 << k) <= nums.length; i++) {
                    t[i][k] = Math.min(t[i][k - 1], t[i + (1 << (k - 1))][k - 1]);
                }
            }
        }
    }
}
