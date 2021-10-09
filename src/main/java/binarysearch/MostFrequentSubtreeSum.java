package binarysearch;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class MostFrequentSubtreeSum {
    private Map<Integer, Integer> freq = new HashMap<>();

    public int solve(Tree root) {
        go(root);
        return freq.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .get();
    }

    private int go(Tree root) {
        if (root == null) return 0;
        int sum = go(root.left) + go(root.right) + root.val;
        freq.merge(sum, 1, Integer::sum);
        return sum;
    }

    public static class Tree {
        public int val;
        public Tree left;
        public Tree right;
    }
}
