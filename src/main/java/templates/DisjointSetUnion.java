package templates;

import java.util.HashMap;
import java.util.Map;

public class DisjointSetUnion {
    private Map<Integer, Integer> parents = new HashMap<>();
    private Map<Integer, Integer> sizes = new HashMap<>();

    public void makeSet(int v) {
        parents.put(v, v);
        sizes.put(v, 1);
    }

    public int findSet(int v) {
        int parent = parents.get(v);
        if (v == parent) return v;
        parent = findSet(parent);
        parents.put(v, parent);
        return parent;
    }

    public void unionSets(int a, int b) {
        a = findSet(a);
        b = findSet(b);
        if (a != b) {
            if (sizes.get(a) < sizes.get(b)) {
                int tmp = a;
                a = b;
                b = tmp;
            }
            parents.put(b, a);
            sizes.merge(a, sizes.get(b), Integer::sum);
        }
    }
}
