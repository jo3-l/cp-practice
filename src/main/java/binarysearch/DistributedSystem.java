package binarysearch;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class DistributedSystem {
    public int solve(int n, int[][] edges) {
        n++;
        int[][] adj = new int[n][n];
        for (int[] e : edges) {
            adj[e[0]][e[1]] = adj[e[1]][e[0]] = e[2];
        }

        int[] ts = new int[n];
        Arrays.fill(ts, Integer.MAX_VALUE);
        ts[0] = 0;
        Queue<QE> pq = new PriorityQueue<>(Comparator.comparing(q -> q.time));
        pq.add(new QE(0, 0));
        while (!pq.isEmpty()) {
            QE e = pq.poll();
            for (int nxt = 0; nxt < n; nxt++) {
                if (nxt != e.to && adj[e.to][nxt] != 0) {
                    int cst = e.time + adj[e.to][nxt];
                    if (cst < ts[nxt]) {
                        ts[nxt] = cst;
                        pq.add(new QE(nxt, cst));
                    }
                }
            }
        }

        int m = Integer.MIN_VALUE;
        for (int v : ts) m = Math.max(m, v);
        return m;
    }

    private static class QE {
        public int to;
        public int time;

        public QE(int to, int time) {
            this.to = to;
            this.time = time;
        }
    }
}
