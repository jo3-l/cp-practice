package binarysearch;

import java.util.HashMap;
import java.util.Map;

public class CityBlocks {
    public int solve(String[][] matrix, String[] blocks) {
        Map<String, int[]> locs = new HashMap<>();
        for (int i = 0; i < matrix.length; i++) {
            String[] r = matrix[i];
            for (int j = 0; j < r.length; j++) {
                locs.put(r[j], new int[]{i, j});
            }
        }
        int i = 0;
        int j = 0;
        int ret = 0;
        for (String p : blocks) {
            int[] loc = locs.get(p);
            int dist = Math.abs(loc[0] - i) + Math.abs(loc[1] - j);
            ret += dist;
            i = loc[0];
            j = loc[1];
        }
        return ret;
    }
}
