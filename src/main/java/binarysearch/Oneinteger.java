package binarysearch;

import java.util.PriorityQueue;
import java.util.Queue;

public class Oneinteger
{
    public int solve(int[] nums) {
        int cost = 0;
        Queue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.add(num);
        }

        while (pq.size() > 1) {
            int v0 = pq.poll();
            int v1 = pq.poll();
            pq.add(v0 + v1);
            cost += v0 + v1;
        }
        return cost;
    }
}
