package binarysearch;

import java.util.ArrayList;
import java.util.List;

public class IntervalOverlaps {
    public int[][] solve(int[][] l0, int[][] l1) {
        List<int[]> res = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < l0.length && j < l1.length) {
            int[] ii = l0[i];
            int[] ij = l1[j];
            if (ii[0] <= ij[0] && ii[1] >= ij[0]) {
                res.add(new int[]{ij[0], Math.min(ii[1], ij[1])});
            } else if (ij[0] <= ii[0] && ij[1] >= ii[0]) {
                res.add(new int[]{ii[0], Math.min(ij[1], ii[1])});
            }
            if (ii[1] < ij[1]) i++;
            else j++;
        }
        int[][] r = new int[res.size()][];
        for (int z = 0; z < res.size(); z++) r[z] = res.get(z);
        return r;
    }
}
