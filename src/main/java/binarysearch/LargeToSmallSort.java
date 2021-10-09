package binarysearch;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class LargeToSmallSort {
    public int[] solve(int[] nums) {
        Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            maxHeap.offer(num);
            minHeap.offer(num);
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (i & 1) == 0 ? maxHeap.poll() : minHeap.poll();
        }
        return nums;
    }
}
