package binarysearch;

import java.util.HashSet;
import java.util.Set;

public class DetectVoterFraud {
    public boolean solve(int[][] votes) {
        Set<Integer> set = new HashSet<>();
        for (int[] pair : votes) set.add(pair[1]);
        return set.size() != votes.length;
    }
}
