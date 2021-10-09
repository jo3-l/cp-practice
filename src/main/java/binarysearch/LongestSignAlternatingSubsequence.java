package binarysearch;

public class LongestSignAlternatingSubsequence {
    public int solve(int[] nums) {
        int len = 0;
        int lastSign = -2;
        for (int num : nums) {
            int sign = (int) Math.signum(num);
            if (lastSign == -2) {
                lastSign = sign;
                len = 1;
            } else {
                if (sign == 0 || sign != lastSign) len++;
                lastSign = sign;
            }
        }
        return len;
    }
}
