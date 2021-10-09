package binarysearch;

public class MakingChange {
    public int solve(int n) {
        int numCoins = 0;
        if (n >= 25) {
            numCoins += n / 25;
            n %= 25;
        }
        if (n >= 10) {
            numCoins += n / 10;
            n %= 10;
        }
        if (n >= 5) {
            numCoins += n / 5;
            n %= 5;
        }
        if (n >= 1) {
            numCoins += n;
        }
        return numCoins;
    }
}
