package binarysearch;

import java.util.*;

public class MixedSorting {
    public int[] solve(int[] nums) {
        List<Integer> evens = new ArrayList<>();
        List<Integer> odds = new ArrayList<>();
        for (int n : nums) {
            if ((n & 1) == 0) evens.add(n);
            else odds.add(n);
        }
        evens.sort(Comparator.naturalOrder());
        odds.sort(Comparator.reverseOrder());
        int i = 0;
        int j = 0;
        for (int z = 0; z < nums.length; z++) {
            if ((nums[z] & 1) == 0) nums[z] = evens.get(i++);
            else nums[z] = odds.get(j++);
        }
        return nums;
    }
 }
