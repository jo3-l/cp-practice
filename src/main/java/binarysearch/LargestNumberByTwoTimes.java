package binarysearch;

public class LargestNumberByTwoTimes {
    public boolean solve(int[] nums) {
        int max0 = Integer.MIN_VALUE;
        int max1 = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num >= max0) {
                int tmp = max0;
                max0 = num;
                max1 = tmp;
            } else if (num > max1) {
                max1 = num;
            }
        }

        return max0 > (max1 << 1);
    }
}
