package binarysearch;

public class NumberOfBits {
    public int solve(int n) {
        int r = 0;
        for (int i = 0; i < 31; i++) {
            if ((n & 1 << i) != 0) r++;
        }
        return r;
    }
}
