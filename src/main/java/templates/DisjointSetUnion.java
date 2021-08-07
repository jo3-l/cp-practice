package templates;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DisjointSetUnion {
    private Map<Integer, Integer> parents = new HashMap<>();
    private Map<Integer, Integer> sizes = new HashMap<>();

    public void make(int v) {
        parents.put(v, v);
        sizes.put(v, 1);
    }

    public int find(int v) {
        int parent = parents.get(v);
        if (v == parent) return v;
        parent = find(parent);
        parents.put(v, parent);
        return parent;
    }

    public void union(int a, int b) {
        a = find(a);
        b = find(b);
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

    public int groupCount() {
        Set<Integer> ps = new HashSet<>();
        for (int p : parents.values()) ps.add(find(p));
        return ps.size();
    }
}
