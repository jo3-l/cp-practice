package binarysearch;

import java.util.Arrays;
import java.util.Comparator;

public class Leaderboard {
    // Note: This solution is too slow on huge inputs, but a C++ equivalent passes just fine /shrug
    public int[] solve(int[] nums) {
        IndexedPair[] ps = new IndexedPair[nums.length];
        for (int i = 0; i < nums.length; i++) ps[i] = new IndexedPair(i, nums[i]);
        Arrays.sort(ps, Comparator.comparing((IndexedPair i) -> i.score).reversed());
        int lastScore = -1;
        int rank = -1;
        for (IndexedPair p : ps) {
            if (p.score != lastScore) ++rank;
            nums[p.idx] = rank;
            lastScore = p.score;
        }
        return nums;
    }

    private static class IndexedPair {
        public int idx;
        public int score;

        public IndexedPair(int idx, int score) {
            this.idx = idx;
            this.score = score;
        }
    }
}
