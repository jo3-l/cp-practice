package binarysearch;

public class BallMoves {
    public int[] solve(int[] nums) {
        int lteb = 0;
        int gtb = 0;
        int[] r = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) continue; // don't care about empty spots
            if (i == 0) {
                lteb++;
            } else {
                gtb++;
                r[0] += i;
            }
        }

        for (int i = 1; i < nums.length; i++) {
            r[i] = r[i - 1] - gtb + lteb;
            if (nums[i] == 1) {
                lteb++;
                gtb--;
            }
        }
        return r;
    }
}
