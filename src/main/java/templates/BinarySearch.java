package templates;

import java.util.function.Predicate;

public class BinarySearch {
    // findIndex returns the index of elem in the sorted array arr.
    // If there are multiple occurrences of elem, the index returned is arbitrary.
    // It returns -1 if no such element was found.
    public static int findIndex(int[] arr, int elem) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] > elem) {
                // value is larger than the target, find in left subarray
                high = mid - 1;
            } else if (arr[mid] == elem) {
                // found it!
                return mid;
            } else {
                // value is lower than the target, find in right subarray
                low = mid + 1;
            }
        }

        // not found :(
        return -1;
    }
}
