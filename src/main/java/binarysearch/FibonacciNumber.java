package binarysearch;

public class FibonacciNumber {
    public int solve(int n) {
        // binet's formula
        return (int) Math.round(Math.pow(/* phi */ 1.618033988749895, n) / Math.sqrt(5));
    }
}
