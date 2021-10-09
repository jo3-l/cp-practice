package binarysearch;

public class LineOfPeople {
    public int solve(int n, int a, int b) {
        return Math.min(b + 1, n - a);
    }
}
