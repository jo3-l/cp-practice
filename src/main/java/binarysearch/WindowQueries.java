package binarysearch;

import java.util.HashMap;
import java.util.Map;

public class WindowQueries {
    public int[] solve(int[] nums, int[] queries, int w) {
        Map<Integer, Integer> ans = new HashMap<>();
        Map<Integer, Integer> windowStart = new HashMap<>();
        for (int l = 0, r = w - 1; l < nums.length; l += w, r += w) {
            for (int i = l; i <= Math.min(r, nums.length - 1); i++) {
                int start = Math.max(Math.max(windowStart.getOrDefault(nums[i], i - w + 1), i - w + 1), 0);
                int end = Math.min(i, nums.length - w);
                if (start <= end) ans.merge(nums[i], end - start + 1, Integer::sum);
                windowStart.put(nums[i], i + 1);
            }
        }

        for (int i = 0; i < queries.length; i++) {
            queries[i] = ans.getOrDefault(queries[i], 0);
        }
        return queries;
    }
}
