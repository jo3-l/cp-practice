package templates;

import java.util.function.Predicate;

public class BinarySearchLowerBound {
    // findFirstIndex returns the first index in the sorted array arr corresponding to a value x where f(x) is true.
    // If no such element could be found, it returns -1.
    public static int findFirstIndex(int[] arr, Predicate<Integer> f) {
        int low = 0;
        int high = arr.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (f.test(arr[mid])) {
                // find in left subarray
                // can't move upper bound to mid-1 since mid may be the first element that satisfies f in the array.
                high = mid;
            } else {
                // find in right subarray
                low = mid + 1;
            }
        }

        return f.test(arr[low]) ? low : -1;
    }
}
