package binarysearch;

public class AppendListToSumTarget {
    public int solve(int[] nums, int k, int target) {
        int t = 0;
        for (int n : nums) t += n;
        if (target < t) {
            int tmp = target;
            target = t;
            t = tmp;
        }
        int cst = 0;
        while (t != target) {
            if (t + k >= target) t = target;
            else t += k;
            cst++;
        }

        return cst;
    }
}
