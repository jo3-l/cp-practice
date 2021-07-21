package templates;

public class SegmentTree {
    // for a vertex at index i, its left subtree is at i * 2, while its right subtree is at i * 2 + 1.
    private final int[] tree;
    private final int N;

    public SegmentTree(int[] arr) {
        N = arr.length;
        tree = new int[N * 4];
        build(arr, 1, 0, N - 1);
    }

    private void build(int[] arr, int idx, int lo, int hi) {
        if (lo == hi) {
            // leaf
            tree[idx] = arr[lo];
        } else {
            int mid = (lo + hi) >> 1;
            // build left subtree
            build(arr, idx << 1, lo, mid);
            // build right subtree
            build(arr, (idx << 1) + 1, mid + 1, hi);
            // merge left and right subtree
            tree[idx] = merge(tree[idx << 1], tree[(idx << 1) + 1]);
        }
    }

    public int sum(int lo, int hi) {
        return doSum(1, 0, N - 1, lo, hi);
    }

    private int doSum(int idx, int curLo, int curHi, int lo, int hi) {
        if (lo > hi) return 0;
        // exact match?
        if (lo == curLo && hi == curHi) return tree[idx];
        int mid = (curLo + curHi) >> 1;
        return merge(
                // left subtree
                doSum(idx << 1, curLo, mid, lo, Math.min(hi, mid)),
                // right subtree
                doSum((idx << 1) + 1, mid + 1, curHi, Math.max(lo, mid + 1), hi)
        );
    }

    public void update(int pos, int newValue) {
        doUpdate(1, 0, N - 1, pos, newValue);
    }

    public void doUpdate(int idx, int lo, int hi, int pos, int newValue) {
        if (lo == hi) {
            // vertex
            tree[idx] = newValue;
        } else {
            int mid = (lo + hi) >> 1;
            if (pos <= mid) doUpdate(idx << 1, lo, mid, pos, newValue); // left subtree
            else doUpdate((idx << 1) + 1, mid + 1, hi, pos, newValue); // right subtree
            tree[idx] = merge(tree[idx << 1], tree[(idx << 1) + 1]); // recompute current vertex value
        }
    }

    private int merge(int x, int y) {
        return x + y;
    }
}
