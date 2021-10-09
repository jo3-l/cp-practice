package binarysearch;

import java.util.HashSet;
import java.util.Set;

public class NoNewFriends {
    public boolean solve(int n, int[][] friends) {
        Set<Integer> s = new HashSet<>();
        for (int[] f : friends) {
            s.add(f[0]);
            s.add(f[1]);
        }

        return s.size() == n;
    }
}
