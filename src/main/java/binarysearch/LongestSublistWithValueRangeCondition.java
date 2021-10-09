package binarysearch;

import java.util.ArrayDeque;
import java.util.Deque;

public class LongestSublistWithValueRangeCondition {
    public int solve(int[] nums) {
        int lo = 0;
        int hi = 0;
        Deque<Integer> minDq = new ArrayDeque<>();
        Deque<Integer> maxDq = new ArrayDeque<>();
        minDq.add(0);
        maxDq.add(0);
        int res = 0;
        while (hi < nums.length) {
            while (!minDq.isEmpty() && minDq.getFirst() < lo) minDq.removeFirst();
            while (!maxDq.isEmpty() && maxDq.getFirst() < lo) maxDq.removeFirst();
            int min = nums[minDq.getFirst()];
            int max = nums[maxDq.getFirst()];

            boolean upd = false;
            if ((min << 1) > max) {
                hi++;
                res = Math.max(res, hi - lo);
                upd = true;
            } else {
                lo++;
                if (lo > hi) {
                    hi++;
                    upd = true;
                }
            }

            if (upd && hi < nums.length) {
                while (!minDq.isEmpty() && nums[minDq.getLast()] > nums[hi]) minDq.removeLast();
                minDq.addLast(hi);
                while (!maxDq.isEmpty() && nums[maxDq.getLast()] < nums[hi]) maxDq.removeLast();
                maxDq.addLast(hi);
            }
        }
        return res;
    }
}
