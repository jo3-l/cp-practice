package binarysearch;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

public class ListConsecutiveSplit {
    public boolean solve(int[] nums, int k) {
        SortedMap<Integer, Integer> st = new TreeMap<>();
        for (int n : nums) st.merge(n, 1, Integer::sum);
        int i = 0;
        while (i < nums.length) {
            SortedMap<Integer, Integer> vu = st.headMap(st.firstKey() + k);
            if (vu.size() != k) return false;
            List<Integer> rm = new ArrayList<>();
            for (SortedMap.Entry<Integer, Integer> e : vu.entrySet()) {
                if (e.getValue() == 1) rm.add(e.getKey());
                else e.setValue(e.getValue() - 1);
                i++;
            }
            for (int vv : rm) vu.remove(vv);
        }
        return true;
    }
}
