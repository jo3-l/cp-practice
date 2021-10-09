package binarysearch;

public class MutableRangeSum {
    private int[] tree;
    private int N;

    public MutableRangeSum(int[] nums) {
        tree = new int[nums.length * 4];
        N = nums.length;
        build(nums, 1, 0, N - 1);
    }

    private void build(int[] nums, int idx, int lo, int hi) {
        if (lo == hi) {
            tree[idx] = nums[lo];
        } else {
            int mid = (lo + hi) >> 1;
            build(nums, idx << 1, lo, mid);
            build(nums, (idx << 1) + 1, mid + 1, hi);
            tree[idx] = merge(tree[idx << 1], tree[(idx << 1) + 1]);
        }
    }

    public int total(int i, int j) {
        return doTotal(1, 0, N - 1, i, j - 1);
    }

    private int doTotal(int idx, int curLo, int curHi, int lo, int hi) {
        if (lo > hi) return 0;
        if (lo == curLo && hi == curHi) return tree[idx];
        int mid = (curLo + curHi) >> 1;
        return merge(
                doTotal(idx << 1, curLo, mid, lo, Math.min(hi, mid)),
                doTotal((idx << 1) + 1, mid + 1, curHi, Math.max(lo, mid + 1), hi)
        );
    }

    public void update(int idx, int val) {
        doUpdate(1, 0, N - 1, idx, val);
    }

    private void doUpdate(int idx, int lo, int hi, int pos, int newValue) {
        if (lo == hi) {
            tree[idx] = newValue;
        } else {
            int mid = (lo + hi) >> 1;
            if (pos <= mid) doUpdate(idx << 1, lo, mid, pos, newValue);
            else doUpdate((idx << 1) + 1, mid + 1, hi, pos, newValue);
            tree[idx] = merge(tree[idx << 1], tree[(idx << 1) + 1]);
        }
    }

    private int merge(int a, int b) {
        return a + b;
    }
}
