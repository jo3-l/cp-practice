package binarysearch;

public class SetBits {
    public int solve(int n) {
        int hsb = 31 - Integer.numberOfLeadingZeros(n);
        int k = (1 << (hsb - 1)) * hsb;
        for (int s = 1 << hsb; s <= n; s++) k += Integer.bitCount(s);
        return k;
    }
}
