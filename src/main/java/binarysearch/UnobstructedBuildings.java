package binarysearch;

import java.util.ArrayList;
import java.util.List;

public class UnobstructedBuildings {
    public int[] solve(int[] heights) {
        List<Integer> can = new ArrayList<>();
        int curMax = -1;
        for (int i = heights.length - 1; i >= 0; i--) {
            int h = heights[i];
            if (curMax == -1 || h > curMax) can.add(i);
            curMax = Math.max(curMax, h);
        }

        int[] ret = new int[can.size()];
        int j = 0;
        for (int i = can.size() - 1; i >= 0; i--) ret[j++] = can.get(i);
        return ret;
    }
}
