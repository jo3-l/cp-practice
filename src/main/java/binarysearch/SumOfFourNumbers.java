package binarysearch;

import java.util.*;

public class SumOfFourNumbers {
    public boolean solve(int[] nums, int k) {
        Map<Integer, Pair> totals = new HashMap<>();
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int total = nums[i] + nums[j];
                totals.putIfAbsent(total, new Pair(i, j));
            }
        }

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int sum = nums[i] + nums[j];
                if (totals.containsKey(k - sum)) {
                     Pair p = totals.get(k - sum);
                     if (p.x != i && p.y != i && p.x != j && p.y != j) return true;
                }
            }
        }
        return false;
    }

    private static class Pair {
        public int x;
        public int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
