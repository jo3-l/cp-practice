package binarysearch;

public class RepeatedAddition {
    public int solve(int n) {
        while (n >= 10) n = sumDigits(n);
        return n;
    }

    private int sumDigits(int n) {
        String s = Integer.toString(n);
        int total = 0;
        for (int i = 0; i < s.length(); i++) {
            total += s.charAt(i) - '0';
        }
        return total;
    }
}
