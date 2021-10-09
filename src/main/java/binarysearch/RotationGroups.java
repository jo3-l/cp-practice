package binarysearch;

import java.util.*;

public class RotationGroups {
    public int solve(String[] words) {
        Map<StrInfo, List<List<String>>> rgs = new HashMap<>();
        int n = 0;
        for (String word : words) {
            long charset = 0;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                int o = c <= '9' ? c - '0' : 10 + c - 'a';
                charset |= (long) 1 << o;
            }
            List<List<String>> rgg = rgs.computeIfAbsent(new StrInfo(charset, word.length()), k -> new ArrayList<>());
            int zz;
            for (zz = 0; zz < rgg.size(); zz++) {
                List<String> rg = rgg.get(zz);
                int z;
                for (z = 0; z < rg.size(); z++) {
                    if (!isRotation(rg.get(z), word)) break;
                }
                if (z >= rg.size()) {
                    rg.add(word);
                    break;
                }
            }

            if (zz >= rgg.size()) {
                List<String> xs = new ArrayList<>();
                xs.add(word);
                rgg.add(xs);
                n++;
            }
        }
        return n;
    }

    private boolean isRotation(String a, String b) {
        for (int i = 0; i < a.length(); i++) {
            if (b.startsWith(a.substring(i)) && b.endsWith(a.substring(0, i))) {
                return true;
            }
        }
        return false;
    }

    private static class StrInfo {
        public long charset;
        public int length;

        public StrInfo(long charset, int length) {
            this.charset = charset;
            this.length = length;
        }

        @Override
        public int hashCode() {
            return Objects.hash(charset, length);
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof StrInfo)) return false;
            StrInfo si = (StrInfo) obj;
            return si.charset == charset && si.length == length;
        }
    }
}
