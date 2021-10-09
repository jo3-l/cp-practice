package binarysearch;

public class LargestSumOf3NonOverlappingSublists {
    public int solve(int[] nums, int k) {
        if (nums.length < 3 * k || k == 0) return 0;
        int N = nums.length - k + 1;
        int[] sums = new int[N];
        for (int i = 0; i < k; i++) sums[0] += nums[i];
        for (int l = 1, r = k; r < nums.length; l++, r++) {
            sums[l] = sums[l - 1] + nums[r] - nums[l - 1];
        }
        int[] maxSumToRight = new int[N];
        maxSumToRight[N - 1] = sums[N - 1];
        for (int i = N - 2; i >= 0; i--) maxSumToRight[i] = Math.max(maxSumToRight[i + 1], sums[i]);
        int[] maxPairSumToRight = new int[N - k];
        maxPairSumToRight[N - k - 1] = sums[N - k - 1] + maxSumToRight[N - 1];
        for (int l = N - k - 2, r = N - 2; l >= 0; r--, l--) {
            maxPairSumToRight[l] = Math.max(maxPairSumToRight[l + 1], sums[l] + maxSumToRight[r]);
        }

        int res = Integer.MIN_VALUE;
        for (int l = 0, r = k; r < N - k; l++, r++) {
            res = Math.max(res, sums[l] + maxPairSumToRight[r]);
        }
        return res;
    }
}
