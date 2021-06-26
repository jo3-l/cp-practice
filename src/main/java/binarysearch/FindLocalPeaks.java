package binarysearch;

import java.util.ArrayList;
import java.util.List;

public class FindLocalPeaks {
    public int[] solve(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int prev = i - 1;
            int next = i + 1;
            boolean gtPrev = prev >= 0 && nums[i] > nums[prev];
            boolean gtNext = next < nums.length && nums[i] > nums[next];
            if (
                    ((i == 0 || i == nums.length - 1) && (gtPrev || gtNext))
                            || (gtPrev && gtNext)
            ) {
                res.add(i);
            }
        }

        int[] ret = new int[res.size()];
        for (int i = 0; i < res.size(); i++) ret[i] = res.get(i);
        return ret;
    }
}
