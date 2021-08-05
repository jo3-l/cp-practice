package binarysearch;

public class MinimizeAmplitudeAfterDeletingKLengthSublist {
    public int solve(int[] nums, int k) {
        if (nums.length == 0 || k == nums.length) return 0;
        int[] minr = new int[nums.length]; // minr[i] = min(nums[..i])
        int[] minl = new int[nums.length]; // minl[i] = min(nums[i..])
        int[] maxr = new int[nums.length]; // maxr[i] = max(nums[..i])
        int[] maxl = new int[nums.length]; // maxl[i] = max(nums[i..])
        for (int l = 0, r = nums.length - 1; l < nums.length; l++, r--) {
            if (l == 0) {
                minr[l] = maxr[l] = nums[l];
            } else {
                minr[l] = Math.min(minr[l - 1], nums[l]);
                maxr[l] = Math.max(maxr[l - 1], nums[l]);
            }

            if (r == nums.length - 1) {
                minl[r] = maxl[r] = nums[r];
            } else {
                minl[r] = Math.min(minl[r + 1], nums[r]);
                maxl[r] = Math.max(maxl[r + 1], nums[r]);
            }
        }

        if (k == 0) return maxr[nums.length - 1] - minr[nums.length - 1];

        int best = Integer.MAX_VALUE;
        for (int i = 0, j = k - 1; j < nums.length; i++, j++) {
            int max;
            int min;
            if (i == 0) {
                max = maxl[j + 1];
                min = minl[j + 1];
            } else if (j == nums.length - 1) {
                max = maxr[i - 1];
                min = minr[i - 1];
            } else {
                max = Math.max(maxr[i - 1], maxl[j + 1]);
                min = Math.min(minr[i - 1], minl[j + 1]);
            }
            best = Math.min(best, max - min);
        }
        return best;
    }
}
