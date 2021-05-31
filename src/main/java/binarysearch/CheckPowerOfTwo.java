package binarysearch;

public class CheckPowerOfTwo {
    public boolean solve(int n) {
        int set = 0;
        for (int i = 0; i <= 31; i++) {
            set += (n & (1 << i)) == 0 ? 0 : 1;
        }
        return set == 1;
    }
}
