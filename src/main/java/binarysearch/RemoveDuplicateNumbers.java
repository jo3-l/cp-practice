package binarysearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RemoveDuplicateNumbers {
    public int[] solve(int[] nums) {
        Map<Integer, Integer> mp = new HashMap<>();
        for (int num : nums) {
            mp.merge(num, 1, Integer::sum);
        }

        List<Integer> res = new ArrayList<>();
        for (int num : nums) {
            if (mp.get(num) == 1) res.add(num);
        }

        int[] r = new int[res.size()];
        for (int i = 0; i < res.size(); i++) r[i] = res.get(i);
        return r;
    }
}
