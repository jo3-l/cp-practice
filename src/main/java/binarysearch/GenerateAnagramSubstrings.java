package binarysearch;

import java.util.*;

public class GenerateAnagramSubstrings {
    public String[] solve(String s) {
        Map<Integer, List<Substr>> all = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            int pt = 0;
            int[] fpt = new int[26];
            for (int j = i; j < s.length(); j++) {
                int c = s.charAt(j) - 'a';
                pt |= 1 << c;
                fpt[c]++;
                List<Substr> ss = all.computeIfAbsent(pt, k -> new ArrayList<>());
                ss.add(new Substr(i, j, Arrays.copyOf(fpt, fpt.length)));
            }
        }

        Set<Substr> d = new HashSet<>();
        List<String> ret = new ArrayList<>();
        for (List<Substr> v : all.values()) {
            for (int i = 0; i < v.size(); i++) {
                for (int j = i + 1; j < v.size(); j++) {
                    if (i == j) continue;
                    Substr a = v.get(i);
                    Substr b = v.get(j);
                    if (Arrays.equals(a.freq, b.freq)) {
                        if (d.add(a)) ret.add(s.substring(a.i, a.j + 1));
                        if (d.add(b)) ret.add(s.substring(b.i, b.j + 1));
                    }
                }
            }
        }
        ret.sort(Comparator.naturalOrder());
        return ret.toArray(new String[]{});
    }

    private static class Substr {
        public int i;
        public int j;
        public int[] freq;

        public Substr(int i, int j, int[] freq) {
            this.i = i;
            this.j = j;
            this.freq = freq;
        }

        @Override
        public int hashCode() {
            return Objects.hash(i, j);
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Substr)) return false;
            Substr ss = (Substr) obj;
            return ss.i == i && ss.j == j;
        }
    }
}
