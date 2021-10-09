package binarysearch;

public class SumOfFirstNOddIntegers {
    public int solve(int n) {
        if (n < 2) return n;
        // 1 + 3 + 5 + ...
        // is equal to:
        // 1 + (1 + 2*1) + (1 + 2*2) + (1 + 2*3) + ...
        // is equal to:
        // 1 + 1 + 1 + 1 + ... + (2 * (1 + 2 + 3 + ...))
        //    ^ n nums                 ^ n - 1 numbers
        // which is equal to:
        // n + [2 * (n * (n - 1))] / 2
        // which simplifies to simply:
        // n ^ 2
        return n * n;
    }
}
