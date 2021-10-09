package templates;

// Implementation from https://codeforces.com/blog/entry/18051
public class SegmentTree {
    private int[] data; // node i's children are at i * 2 (left), i * 2 + 1 (right)
    private int len;

    public SegmentTree(int[] arr) {
        len = arr.length;
        data = new int[len * 2];
        init(arr);
    }

    // sets value at index
    public void modify(int index, int value) {
        index += len; // get the leaf node position
        data[index] = value; // set the corresponding leaf node's value
        for (; index > 1; index /= 2) {
            data[index / 2] = data[index] + data[index ^ 1];
        }
    }

    // sums elements in [l, r)
    public int query(int l, int r) {
        int res = 0;

        // start at the leaf nodes for l and r.
        l += len;
        r += len;
        while (l < r) {
            // is the left interval border odd?
            if ((l & 1) == 1) {
                // odd index means that it must be the right child of its parent.
                // since it is the right child, and it's the left interval border (inclusive), include it.
                // increment it so we don't include its parent (as that would count it twice). instead, move
                // right.
                res += data[l++];
            }

            // is the right interval border odd?
            if ((r & 1) == 1) {
                // similar logic: r is the right child of its parent.
                // in this case, r is the right interval border (exclusive), so we shouldn't include it.
                // similarly, its parent should not be included as that would include the right boundary value.
                // instead, move left.
                res += data[--r];
            }

            // go to parents
            l /= 2;
            r /= 2;
        }

        return res;
    }

    private void init(int[] arr) {
        for (int i = 0; i < arr.length; i++) data[i + len] = arr[i]; // set leaf node values
        // set parent node values
        for (int i = len - 1; i > 0; i--) {
            // the child nodes of node i are i*2 and i*2+1, sum them up to get the parent value
            data[i] = data[i * 2] + data[i * 2 + 1];
        }
    }
}
