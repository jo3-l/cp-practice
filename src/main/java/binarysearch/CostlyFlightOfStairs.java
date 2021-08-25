package binarysearch;

import java.util.ArrayDeque;
import java.util.Deque;

public class CostlyFlightOfStairs {
    public int solve(int[] stairs, int k) {
        int[] dp = new int[stairs.length];
        dp[0] = stairs[0];
        Deque<Integer> dq = new ArrayDeque<>();
        dq.add(0);
        for (int i = 1; i < stairs.length; i++) {
            while (!dq.isEmpty() && dq.getFirst() < i - k) dq.removeFirst();
            int minCost = dp[dq.getFirst()];
            if (minCost == Integer.MAX_VALUE) dp[i] = Integer.MAX_VALUE;
            else dp[i] = minCost + stairs[i];
            while (!dq.isEmpty() && dp[dq.getLast()] > dp[i]) dq.removeLast();
            dq.addLast(i);
        }
        return dp[stairs.length - 1];
    }
}
