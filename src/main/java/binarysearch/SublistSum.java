package binarysearch;

public class SublistSum {
    public boolean solve(int[] nums) {
        int maxEndingHere = 0;
        int maxSoFar = 0;
        int sum = 0;
        for (int num : nums) {
            sum += num;
            maxEndingHere = Math.max(0, maxEndingHere + num);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar > sum;
    }
}
