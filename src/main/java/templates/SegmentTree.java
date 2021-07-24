package templates;

// Implementation from https://codeforces.com/blog/entry/18051
public class SegmentTree {
    private int[] data; // node i's children are at i * 2 (left), i * 2 + 1 (right)
    private int len;

    public SegmentTree(int[] arr) {
        len = arr.length;
        data = new int[arr.length * 2];
        init(arr);
    }

    // sets value at index
    public void modify(int index, int value) {
        data[index += len] = value; // set the corresponding leaf node's value
        // set parent node values
        for (; index > 1; index /= 2) {
            data[index / 2] = data[index] + data[index ^ 1]; // sum up child nodes
        }
    }

    // sums elements in [l, r)
    public int query(int l, int r) {
        int result = 0;

        l += len;
        r += len;
        while (l < r) {
            // is the left interval border odd?
            if ((l & 1) != 0) {
                // l is the right child, include it but not its parent
                result += data[l++];
            }
            // is the right interval border odd?
            if ((r & 1) != 0) {
                // r is the right child, include the left child instead and skip its parent
                result += data[--r];
            }

            // go to parents
            l /= 2;
            r /= 2;
        }

        return result;
    }

    private void init(int[] arr) {
        // for (int i = 0; i < arr.length; i++) data[i + len] = arr[i];
        System.arraycopy(arr, 0, data, len, arr.length); // set leaf node values
        // set parent node values
        for (int i = len - 1; i > 0; i--) {
            data[i] = data[i * 2] + data[i * 2 + 1]; // sum up child nodes
        }
    }
}
