package binarysearch;

public class CheckPerfectSquare {
    public boolean solve(int n) {
        if (n < 2) return true;

        int dec = n % 10;
        if (dec == 2 || dec == 3 || dec == 7 || dec == 8) return false;

        for (int i = 1; i * i <= n; i++) {
            if (i * i == n) return true;
        }
        return false;
    }
}
