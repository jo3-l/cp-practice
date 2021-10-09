package binarysearch;

public class ThreeAndSeven {
    public boolean solve(int n) {
        while (n >= 0) {
            if (n % 3 == 0 || n % 7 == 0) return true;
            n -= 10;
        }
        return false;
    }
}
