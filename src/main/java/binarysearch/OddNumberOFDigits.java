package binarysearch;

public class OddNumberOFDigits {
    public int solve(int[] nums) {
        int x = 0;
        for (int num : nums) {
            int n = (int) Math.log10(num);
            if ((n & 1) == 0) x++;
        }
        return x;
    }
}
