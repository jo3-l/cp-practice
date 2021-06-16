package binarysearch;

public class MinimumInitialValuePositivePrefixSums {
    public int solve(int[] nums) {
        int want = -1;
        int total = 0;
        for (int num : nums) {
            total += num;
            if (total < 0) {
                want = Math.max(want, -total);
            }
        }

        return want + 1;
    }
}
