package binarysearch;

public class NextBinaryPermutation {
    public int solve(int n) {
        // shift the first one with a zero above it to the next pos
        int cnt = 0;
        for (int i = 0; i < 32; i++) {
            int ib = 1 << i;
            int nb = 1 << (i + 1);
            boolean s = (n & ib) != 0;
            if (s && (n & nb) == 0) {
                n &= ~(nb - 1);
                n |= nb;
                n |= (1 << cnt) - 1;
                return n;
            }

            if (s) cnt++;
        }
        return -1;
    }
}
