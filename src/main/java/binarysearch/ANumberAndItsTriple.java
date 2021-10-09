package binarysearch;

import java.util.HashSet;
import java.util.Set;

public class ANumberAndItsTriple {
    public boolean solve(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int zeroCount = 0;
        for (int num : nums) {
            if (num == 0) zeroCount++;
            set.add(num);
        }
        for (int v : set) {
            if (v == 0 && zeroCount < 2) continue;
            if (set.contains(v * 3)) return true;
        }
        return false;
    }
}
