package binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReverseGraph {
    public int[][] solve(int[][] graph) {
        if (graph.length == 0) return graph;

        @SuppressWarnings("unchecked")
        List<Integer>[] res = new List[graph.length];
        for (int v = 0; v < graph.length; v++) {
            int[] adjacency = graph[v];
            for (int vv : adjacency) {
                if (res[vv] == null) res[vv] = new ArrayList<>();
                res[vv].add(v);
            }
        }

        int[][] ret = new int[graph.length][];
        for (int i = 0; i < res.length; i++) {
            List<Integer> l = res[i];
            if (l == null) ret[i] = new int[]{};
            else {
                int[] conv = new int[l.size()];
                for (int j = 0; j < l.size(); j++) conv[j] = l.get(j);
                Arrays.sort(conv);
                ret[i] = conv;
            }
        }
        return ret;
    }
}
