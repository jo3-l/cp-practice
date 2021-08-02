package binarysearch;

import java.util.ArrayDeque;
import java.util.Queue;

public class ConcatenatedStringOfUniqueCount {
    public int solve(String[] words) {
        int[] hsh = new int[words.length];
        outer: for (int i = 0; i < words.length; i++) {
            int n = 0;
            for (int j = 0; j < words[i].length(); j++) {
                int b = 1 << (words[i].charAt(j) - 'a');
                if ((n & b) != 0) {
                    hsh[i] = -1;
                    continue outer;
                }
                n |= 1 << (words[i].charAt(j) - 'a');
            }
            hsh[i] = n;
        }

        Queue<V> q = new ArrayDeque<>();
        int mx = 0;
        for (int i = 0; i < words.length; i++) {
            if (hsh[i] == -1) continue;
            int l = words[i].length();
            q.add(new V(hsh[i], l, i));
            mx = Math.max(mx, l);
        }
        while (!q.isEmpty()) {
            V cur = q.poll();
            for (int j = cur.last + 1; j < words.length; j++) {
                if (hsh[j] == -1) continue;
                if ((cur.hsh & hsh[j]) == 0) {
                    int m = cur.hsh | hsh[j];
                    int l = cur.len + words[j].length();
                    q.add(new V(m, l, j));
                    mx = Math.max(mx, l);
                }
            }
        }
        return mx;
    }

    private static class V {
        public int hsh;
        public int len;
        public int last;

        public V(int hsh, int len, int last) {
            this.hsh = hsh;
            this.len = len;
            this.last = last;
        }
    }
}
