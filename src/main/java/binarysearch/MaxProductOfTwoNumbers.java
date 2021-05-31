package binarysearch;

public class MaxProductOfTwoNumbers {
    public int solve(int[] nums) {
        int second = Integer.MIN_VALUE;
        int first = Integer.MIN_VALUE;

        int secondLast = Integer.MAX_VALUE;
        int last = Integer.MAX_VALUE;
        for (int v : nums) {
            if (v > first) {
                int tmp = first;
                first = v;
                second = tmp;
            } else if (v == first || v > second) {
                second = v;
            }

            if (v < last) {
                int tmp = last;
                last = v;
                secondLast = tmp;
            } else if (v == last || v < secondLast) {
                secondLast = v;
            }
        }

        return Math.max(first * second, last * secondLast);
    }
}
