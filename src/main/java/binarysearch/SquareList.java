package binarysearch;

// If you're reading this for whatever reason... this is hilariously overcomplicated
// Not sure what I was thinking when I made it
// But, it works, and I learnt more about binary search... so...

public class SquareList {
    public int[] solve(int[] nums) {
        if (nums.length == 0) return new int[]{};

        int lower = findLastNegativeNumIdx(nums);
        int upper = findFirstPositiveIdx(nums);

        int zeroCount = 0; // number of zeroes, to put at the front of the resulting array
        if (lower == -1) {
            if (upper == -1) {
                // all zeros, lucky!
                return nums;
            }

            // example: if the first positive number is at index 1, there is 1 zero
            zeroCount = upper;
        } else {
            zeroCount = upper == -1
                    ? nums.length - lower - 1 // example: 3 numbers [-1 0 0], start of positive numbers is 0, 3 - 0 - 1 = 2
                    : upper - lower - 1; // example: 4 numbers [-1 0 0 1], upper => 3, lower => 0, 3 - 0 - 1 = 2
        }

        int[] result = new int[nums.length];
        int i = zeroCount; // skip zeroes

        int vLower = -1; // value moving towards the left of the array
        int vUpper = -1; // value moving towards the right of the array
        while (i < result.length) {
            if (lower >= 0 && vLower == -1) {
                int v = nums[lower--];
                vLower = v * v;
            }
            if (upper >= 0 && upper < result.length && vUpper == -1) {
                int v = nums[upper++];
                vUpper = v * v;
            }

            if (vLower == vUpper && vLower != -1) {
                result[i++] = vLower;
                result[i++] = vUpper;

                vLower = -1;
                vUpper = -1;
            } else if ((vLower != -1 && vLower < vUpper) || vUpper == -1) {
                result[i++] = vLower;
                vLower = -1;
            } else {
                result[i++] = vUpper;
                vUpper = -1;
            }
        }

        return result;
    }

    private int findFirstPositiveIdx(int[] arr) {
        // find the first element that is greater than 0
        int low = 0;
        int high = arr.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] > 0) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return arr[low] > 0 ? low : -1;
    }

    private int findLastNegativeNumIdx(int[] arr) {
        // find the last element that is less than 0
        int low = 0;
        int high = arr.length - 1;
        while (low < high) {
            int mid = low + (high - low + 1) / 2;
            if (arr[mid] < 0) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }

        return arr[low] < 0 ? low : -1;
    }
}
