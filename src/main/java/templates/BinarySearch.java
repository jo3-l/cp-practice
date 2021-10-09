package templates;

public class BinarySearch {
    // classic binary search algorithm for finding an element exactly
    public static int findIndex(int[] arr, int elem) {
        int lo = 0;
        int hi = arr.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] > elem) {
                // value is larger than the target; so anything higher can't match. move to the left subarray
                hi = mid - 1;
            } else if (arr[mid] == elem) {
                // found it!
                return mid;
            } else {
                // value is lower than the target; so anything lower can't match. move to the right subarray
                lo = mid + 1;
            }
        }

        // not found
        return -1;
    }

    // lower bound variant of binary search; in this case we are searching for the first value < n.
    private static int findFirstGreater(int[] arr, int n) {
        int lo = 0;
        int hi = arr.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] < n) {
                // value matches the predicate x < n; move to the left subarray but keep mid:
                // nothing above mid should be considered, but mid may well be the first element that matches
                hi = mid;
            } else {
                // value doesn't match; so anything lower can't. move to the right subarray
                lo = mid + 1;
            }
        }

        // this check (arr[lo] < n) can be avoided if we keep an auxiliary variable res initialized to -1 and assign
        // it to mid whenever we find a match, but this is simpler in most cases.
        // also note that when using an approach like described above with an auxiliary variable, one
        // has to be cautious about lo==hi at the start (as can happen with 1-element arrays).
        return arr[lo] < n ? lo : -1;
    }

    // upper bound variant of binary search; in this case we are searching for the last value > n.
    private static int findLastLower(int[] arr, int n) {
        int lo = 0;
        int hi = arr.length - 1;
        while (lo < hi) {
            // note that the +1 is needed in order to avoid infinite loops where we get stuck on lo.
            int mid = lo + (hi - lo + 1) / 2;
            if (arr[mid] > n) {
                // value matches the predicate x > n; move to the right subarray but keep mid:
                // nothing below mid should be considered, but mid may well be the last element that matches
                lo = mid;
            } else {
                // value doesn't match; so anything higher can't. move to the left subarray
                hi = mid - 1;
            }
        }

        // similar to lower bound
        return arr[lo] > n ? lo : -1;
    }
}
