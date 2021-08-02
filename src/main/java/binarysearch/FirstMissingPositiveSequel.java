package binarysearch;

public class FirstMissingPositiveSequel {
    public int solve(int[] arr) {
        if (arr.length == 0) return 1;
        int fo = firstGteOneIdx(arr);
        if (fo == arr.length || arr[fo] != 1) return 1;
        int mx = maxLteXIdx(arr, arr.length + 1);
        for (int i = fo; i < maxLteXIdx(arr, arr.length + 1); i++) {
            if (arr[i] + 1 != arr[i + 1]) return arr[i] + 1;
        }
        return arr[mx == arr.length ? arr.length - 1 : mx] + 1;
    }

    private int firstGteOneIdx(int[] arr) {
        int lo = 0;
        int hi = arr.length - 1;
        while (lo < hi) {
            int mid = (lo + hi) >> 1;
            if (arr[mid] >= 1) hi = mid;
            else lo = mid + 1;
        }
        return arr[lo] >= 1 ? lo : arr.length;
    }

    private int maxLteXIdx(int[] arr, int x) {
        int lo =0;
        int hi = arr.length-1;
        while (lo < hi) {
            int mid = (lo + hi + 1) >> 1;
            if (arr[mid] <= x) lo = mid;
            else hi = mid - 1;
        }
        return arr[lo] <= x ? lo : arr.length;
    }
}
