package binarysearch;

import java.util.ArrayList;
import java.util.List;

public class PartitionString {
    public int[] solve(String s) {
        int[] lastLoc = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lastLoc[s.charAt(i) - 'a'] = i;
        }

        List<Integer> ls = new ArrayList<>();
        int needEnd = 0;
        int lastStop = -1;
        for (int i = 0; i < s.length(); i++) {
            int o = s.charAt(i) - 'a';
            int bit = 1 << o;
            if (lastLoc[o] == i) {
                needEnd &= ~bit;
            } else {
                needEnd |= 1 << o;
            }
            if (needEnd == 0) {
                ls.add(i - lastStop);
                lastStop = i;
            }
        }
        int[] ret = new int[ls.size()];
        for (int i = 0; i < ls.size(); i++) ret[i] = ls.get(i);
        return ret;
    }
}
