package templates;

import java.util.function.Predicate;

public class BinarySearchUpperBound {
    // findLastIndex returns the last index in the sorted array arr corresponding to a value x where f(x) is true.
    // If no such element could be found, it returns -1.
    public static int findLastIndex(int[] arr, Predicate<Integer> f) {
        int low = 0;
        int high = arr.length - 1;
        while (low < high) {
            // +1 to round up
            int mid = low + (high - low + 1) / 2;
            if (f.test(arr[mid])) {
                // find in right subarray
                // can't move lower bound to mid+1 since mid may be the last element that satisfies f in the array.
                low = mid;
            } else {
                // find in left subarray
                high = mid - 1;
            }
        }

        return f.test(arr[low]) ? low : -1;
    }
}
