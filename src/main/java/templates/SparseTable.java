package templates;

public class SparseTable {
    private int[][] data;

    public SparseTable(int[] arr) {
        data = new int[arr.length][ceilLog2(arr.length) + 1];
        init(arr);
    }

    // min on [i, j]
    public int query(int i, int j) {
        int n = floorLog2(j - i + 1);
        return Math.min(data[i][n], data[j - (1 << n) + 1][n]);
    }

    private void init(int[] arr) {
        for (int i = 0; i < arr.length; i++) data[i][0] = arr[i];

        for (int k = 1; k <= ceilLog2(arr.length); k++) {
            for (int i = 0; i + (1 << k) <= arr.length; i++) {
                data[i][k] = Math.min(data[i][k - 1], data[i + (1 << (k - 1))][k - 1]);
            }
        }
    }

    private static int floorLog2(int n) {
        return 31 - Integer.numberOfLeadingZeros(n);
    }

    private static int ceilLog2(int n) {
        return 32 - Integer.numberOfLeadingZeros(n - 1);
    }
}
