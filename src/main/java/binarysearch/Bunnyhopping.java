package binarysearch;

import java.util.ArrayDeque;
import java.util.Deque;

public class Bunnyhopping {
    public int solve(int[] nums, int k) {
        int N = nums.length;
        int[] dp = new int[N];
        dp[0] = nums[0];
        Deque<Integer> q = new ArrayDeque<>();
        q.add(0);
        for (int i = 1; i < N; i++) {
            if (i > k) {
                if (!q.isEmpty() && q.getFirst() < i - k) q.removeFirst();
            }
            dp[i] = nums[i] + dp[q.getFirst()];
            while (!q.isEmpty() && dp[q.getLast()] > dp[i]) q.removeLast();
            q.addLast(i);
        }
        return dp[N - 1];
    }
}
