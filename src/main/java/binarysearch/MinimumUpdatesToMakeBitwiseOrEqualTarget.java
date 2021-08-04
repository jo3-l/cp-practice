package binarysearch;

public class MinimumUpdatesToMakeBitwiseOrEqualTarget {
    public int solve(int a, int b, int target) {
        int aExtra = a & ~target;
        int bExtra = b & ~target;
        int targetExtra = target & ~(a | b);
        return Integer.bitCount(aExtra) + Integer.bitCount(bExtra) + Integer.bitCount(targetExtra);
    }
}
