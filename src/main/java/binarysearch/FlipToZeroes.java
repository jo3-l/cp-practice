package binarysearch;

public class FlipToZeroes {
    public int solve(int[] nums) {
        int i = 0;
        int flag = 0;
        int n = 0;
        while (i < nums.length) {
            if ((nums[i++] ^ flag) == 0) continue;
            while (i < nums.length && (nums[i] ^ flag) == 1) i++;
            n++;
            flag ^= 1;
        }
        return n;
    }
}
