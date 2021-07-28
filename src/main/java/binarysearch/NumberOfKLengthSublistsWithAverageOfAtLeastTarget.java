package binarysearch;

public class NumberOfKLengthSublistsWithAverageOfAtLeastTarget {
    public int solve(int[] nums, int k, int target) {
        int n = 0;
        int total = 0;
        for (int i = 0, j = k - 1; j < nums.length; i++, j++) {
            if (i == 0) {
                for (int z = i; z <= j; z++) total += nums[z];
            } else {
                total += nums[j];
                total -= nums[i - 1];
            }

            if ((double) (total / k) >= target) n++;
        }

        return n;
    }
}
