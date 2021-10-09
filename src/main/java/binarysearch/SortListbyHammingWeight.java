package binarysearch;

import java.util.Arrays;
import java.util.Comparator;

public class SortListbyHammingWeight {
    public int[] solve(int[] nums) {
        Integer[] boxed = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) boxed[i] = nums[i];
        Arrays.sort(boxed, Comparator.comparing(Integer::bitCount).thenComparing(Integer::intValue));
        int[] ret = new int[boxed.length];
        for (int i = 0; i < boxed.length; i++) ret[i] = boxed[i];
        return ret;
    }
}
