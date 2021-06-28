package binarysearch;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestStream {
    private Queue<Integer> pq = new PriorityQueue<>();

    public KthLargestStream(int[] nums, int k) {
        for (int num : nums) pq.offer(num);
        // remove |nums| - k - 1 values
        for (int i = 0; i < nums.length - k - 1; i++) pq.poll();
    }

    public int add(int val) {
        int cur = pq.peek();
        if (val > cur) {
            pq.poll();
            pq.add(val);
        }
        return pq.peek();
    }
}
