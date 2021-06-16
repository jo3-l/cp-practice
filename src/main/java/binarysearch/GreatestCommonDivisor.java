package binarysearch;

public class GreatestCommonDivisor {
    public int solve(int[] nums) {
        int g = nums[0];
        for (int i = 1; i < nums.length; i++) g = gcd(g, nums[i]);
        return g;
    }

    private int gcd(int a, int b) {
        while (b > 0) {
            int tmp = b;
            b = a % b;
            a = tmp;
        }
        return a;
    }
}
