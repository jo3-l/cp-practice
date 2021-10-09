package binarysearch;

import java.util.Arrays;

public class ThreePlayerCoinGame {
    public int solve(int[] piles) {
        Arrays.sort(piles);
        int n = 0;
        for (int i = piles.length - 2, r = 0; i > r; i -= 2, r++) {
            n += piles[i];
        }
        return n;
    }
}
