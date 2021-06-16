package binarysearch;

import java.util.HashSet;
import java.util.Set;

public class KAndNegativeK {
    public int solve(int[] nums) {
        int v = Integer.MIN_VALUE;

        Set<Integer> st = new HashSet<>();
        for (int num : nums) {
            st.add(num);
            if (st.contains(-num)) v = Math.max(v, Math.max(num, -num));
        }
        return v == Integer.MIN_VALUE ? -1 : v;
    }
}
