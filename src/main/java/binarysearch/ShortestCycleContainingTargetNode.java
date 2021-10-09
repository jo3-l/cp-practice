package binarysearch;

import java.util.ArrayDeque;
import java.util.BitSet;
import java.util.Queue;

public class ShortestCycleContainingTargetNode {
    public int solve(int[][] graph, int target) {
        Queue<Integer> dq = new ArrayDeque<>();
        dq.add(target);
        BitSet seen = new BitSet(graph.length);
        int len = 1;
        seen.set(target);
        while (!dq.isEmpty()) {
            int sz = dq.size();
            while (sz-- > 0) {
                int to = dq.poll();
                int[] adj = graph[to];
                for (int nxt : adj) {
                    if (nxt == target) return len;
                    if (seen.get(nxt)) continue;
                    seen.set(nxt);
                    dq.offer(nxt);
                }
            }
            len++;
        }
        return -1;
    }
}
