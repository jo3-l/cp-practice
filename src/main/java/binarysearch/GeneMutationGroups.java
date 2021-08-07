package binarysearch;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GeneMutationGroups {
    public int solve(String[] genes) {
        DSU dsu = new DSU();
        for (String s : genes) dsu.make(s);
        for (int i = 0; i < genes.length; i++) {
            for (int j = i + 1; j < genes.length; j++) {
                if (sameExceptOne(genes[i], genes[j])) dsu.union(genes[i], genes[j]);
            }
        }
        Set<String> ps = new HashSet<>();
        for (String s : dsu.parent.values()) ps.add(dsu.find(s));
        return ps.size();
    }

    private boolean sameExceptOne(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                if (diff++ == 1) return false;
            }
        }
        return diff == 1;
    }

    private static class DSU {
        public Map<String, String> parent = new HashMap<>();
        private Map<String, Integer> size = new HashMap<>();

        public void make(String s) {
            parent.put(s, s);
            size.put(s, 1);
        }

        public String find(String s) {
            String p = parent.get(s);
            if (p.equals(s)) return p;
            String pp = find(p);
            parent.put(s, pp);
            return pp;
        }

        public void union(String a, String b) {
            a = find(a);
            b = find(b);
            if (a.equals(b)) return;
            if (size.get(a) < size.get(b)) {
                String tmp = a;
                a = b;
                b = tmp;
            }
            parent.put(b, a);
            size.merge(b, size.get(a), Integer::sum);
        }
    }
}
