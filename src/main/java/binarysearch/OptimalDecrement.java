package binarysearch;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class OptimalDecrement {
    public int solve(int[] nums, int k) {
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int num : nums) pq.add(num);
        while (k-- > 0) pq.add(pq.remove() - 1);
        return pq.poll();
    }
}
