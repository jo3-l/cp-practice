package binarysearch;

import java.util.ArrayList;
import java.util.List;

public class PackingBoxes {
    public int[][] solve(int[] nums) {
        List<List<Integer>> ls = new ArrayList<>();
        int i = 0;
        while (i < nums.length) {
            int v = nums[i++];
            List<Integer> store = new ArrayList<>();
            store.add(v);
            ls.add(store);
            while (i < nums.length && nums[i] == v) {
                store.add(v);
                i++;
            }
        }

        int[][] ret = new int[ls.size()][];
        for (int z = 0; z < ls.size(); z++) {
            List<Integer> t = ls.get(z);
            int[] tmp = new int[t.size()];
            for (int j = 0; j < t.size(); j++) tmp[j] = t.get(j);
            ret[z] = tmp;
        }
        return ret;
    }
}
