package binarysearch;

import java.util.Arrays;

public class MinimumDifference {
    public int solve(int[] lst0, int[] lst1) {
        if (lst0.length == 0) return 0;
        Arrays.sort(lst0);
        Arrays.sort(lst1);
        int best = Integer.MAX_VALUE;
        for (int n : lst0) {
            int li = findLte(lst1, n);
            if (li != -1) best = Math.min(best, Math.abs(n - lst1[li]));
            int gi = findGte(lst1, n);
            if (gi != -1) best = Math.min(best, Math.abs(n - lst1[gi]));
        }
        return best;
    }

    private int findGte(int[] nums, int n) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            int mid = (lo + hi) >> 1;
            if (nums[mid] >= n) hi = mid;
            else lo = mid + 1;
        }
        return nums[lo] >= n ? lo : -1;
    }

    private int findLte(int[] nums, int n) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            int mid = (lo + hi + 1) >> 1;
            if (nums[mid] <= n) lo = mid;
            else hi = mid - 1;
        }
        return nums[lo] <= n ? lo : -1;
    }
}
