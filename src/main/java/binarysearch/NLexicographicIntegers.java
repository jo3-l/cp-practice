package binarysearch;

import java.util.Arrays;

public class NLexicographicIntegers {
    public int[] solve(int n) {
        String[] ret = new String[n];
        for (int i = 1; i <= n; i++) ret[i - 1] = Integer.toString(i);
        Arrays.sort(ret);
        int[] res = new int[n];
        for (int i = 0; i < ret.length; i++) res[i] = Integer.parseInt(ret[i]);
        return res;
    }
}
