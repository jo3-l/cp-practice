package binarysearch;

public class CoprimeSuspects {
    public int solve(int a, int b) {
        if (gcd(a, b) != 1) return 0;
        if (gcd(a - 1, b) != 1 || gcd(a, b - 1) != 1 || gcd(a + 1, b) != 1 || gcd(a, b + 1) != 1) return 1;
        return 2;
    }

    private int gcd(int a, int b) {
        while (b > 0) {
            int tmp = b;
            b = a % b;
            a = tmp;
        }
        return a;
    }
}
