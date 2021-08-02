package binarysearch;

import java.util.HashMap;
import java.util.Map;

public class NumberOfQuadrupletsThatSumTarget {
    public int solve(int[] a, int[] b, int[] c, int[] d, int target) {
        Map<Integer, Integer> x = new HashMap<>();
        for (int k : c) {
            for (int i : d) x.merge(k + i, 1, Integer::sum);
        }

        int n = 0;
        for (int i : a) {
            for (int j : b) {
                n += x.getOrDefault(target - i - j, 0);
            }
        }
        return n;
    }
}
