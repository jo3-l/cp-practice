package binarysearch;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class CellFusion {
    public int solve(int[] cells) {
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int cell : cells) pq.add(cell);
        while (pq.size() >= 2) {
            int a = pq.poll();
            int b = pq.poll();
            if (a != b) {
                pq.add((a + b) / 3);
            }
        }

        return pq.isEmpty() ? -1 : pq.poll();
    }
}
