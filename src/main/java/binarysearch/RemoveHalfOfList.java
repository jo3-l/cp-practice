package binarysearch;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RemoveHalfOfList {
    public int solve(int[] nums) {
        int wantRemove = (nums.length + 1) >> 1;
        Map<Integer, Integer> occ = new HashMap<>();
        for (int num : nums) {
            occ.merge(num, 1, Integer::sum);
        }

        int n = 0;
        List<Integer> vs = occ.values().stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
        int i = 0;
        for (; i < vs.size(); i++) {
            n += vs.get(i);
            if (n >= wantRemove) break;
        }
        return i + 1;
    }
}
