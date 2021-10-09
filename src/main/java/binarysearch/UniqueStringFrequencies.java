package binarysearch;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class UniqueStringFrequencies {
    public int solve(String s) {
        int[] f = new int[26];
        for (int i = 0; i < s.length(); i++) f[s.charAt(i) - 'a']++;
        Queue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());
        for (int v : f) if (v != 0) q.offer(v);
        int n = 0;
        while (q.size() >= 2) {
            int top = q.poll();
            int sec = q.poll();
            if (top == sec) {
                q.offer(top);
                if (top != 1) q.offer(top - 1);
                n++;
            } else {
                q.offer(sec);
            }
        }
        return n;
    }
}
