package binarysearch;

import java.util.ArrayDeque;
import java.util.Deque;

public class LongestEquivalentSublistAfterKIncrements {
    public int solve(int[] nums, int k) {
        int lo = 0;
        int hi = nums.length;
        int res = 0;
        while (lo < hi) {
            int mid = (lo + hi + 1) >> 1;
            if (isPossible(nums, mid, k)) {
                lo = res = mid;
            } else {
                hi = mid - 1;
            }
        }
        return res;
    }

    private boolean isPossible(int[] nums, int len, int k) {
        Deque<Integer> q = new ArrayDeque<>();
        int total = 0;
        for (int i = 0; i < len; i++) {
            while (!q.isEmpty() && nums[q.getLast()] < nums[i]) q.removeLast();
            q.addLast(i);
            total += nums[i];
        }
        int firstMax = nums[q.getFirst()];
        if ((firstMax * len) - total <= k) return true;

        for (int l = 1, r = len; r < nums.length; l++, r++) {
            while (!q.isEmpty() && nums[q.getLast()] < nums[r]) q.removeLast();
            q.addLast(r);
            while (!q.isEmpty() && q.getFirst() < l) q.removeFirst();
            int max = nums[q.getFirst()];
            total -= nums[l - 1];
            total += nums[r];
            if ((max * len) - total <= k) return true;
        }
        return false;
    }
}
