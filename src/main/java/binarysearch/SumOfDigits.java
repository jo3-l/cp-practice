package binarysearch;

public class SumOfDigits {
    public int solve(int n) {
        int d = (int) Math.pow(10, (int) Math.log10(n));
        int x = 0;
        while (d > 1) {
            int digit = n / d;
            x += digit;
            n -= digit * d;
            d /= 10;
        }

        return x + n;
    }
}
