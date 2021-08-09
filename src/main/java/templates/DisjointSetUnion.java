package templates;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// union find DS with union by size and path compression optimizations.
public class DisjointSetUnion {
    private Map<Integer, Integer> parent = new HashMap<>();
    private Map<Integer, Integer> size = new HashMap<>();
    private int count;

    public void make(int v) {
        parent.put(v, v);
        size.put(v, 1);
        count++;
    }

    public int find(int v) {
        if (parent.get(v) == v) return v;
        parent.put(v, find(parent.get(v)));
        return parent.get(v);
    }

    public void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) return; // already in the same group

        // combined 2 sets into 1 -> sub 1 from count
        count--;
        // make sure a has more descendants than b
        if (size.get(a) < size.get(b)) {
            int tmp = a;
            a = b;
            b = tmp;
        }
        // attach b (the node with less descendants) to a (the one with more)
        parent.put(b, a);
        // increment size of a
        size.merge(a, size.get(b), Integer::sum);
    }

    public int setCount() {
        return count;
    }
}
