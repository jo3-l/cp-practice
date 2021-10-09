package binarysearch;

import java.util.HashMap;
import java.util.Map;

public class DecimalNumber {
    public String solve(int numerator, int denominator) {
        boolean neg = numerator < 0 != denominator < 0;
        numerator = Math.abs(numerator);
        denominator = Math.abs(denominator);
        int whole = numerator / denominator;
        numerator %= denominator;
        if (numerator == 0) return Integer.toString(whole);
        return (neg ? "-" : "") + whole + "." + divide(numerator, denominator);
    }

    // a / b
    private String divide(int a, int b) {
        // Perform long division.
        // Once we find a cycle, we've found repeating digits.
        StringBuilder sb = new StringBuilder();
        Map<Integer, Integer> pos = new HashMap<>();

        //    ___
        // b / a
        int inner = a;
        int outer = b;
        while (true) {
            inner *= 10;
            int lpos = pos.getOrDefault(inner, -1);
            if (lpos != -1) {
                sb.insert(lpos, '(');
                sb.append(')');
                return sb.toString();
            }

            int res = inner / outer;
            int next = inner % outer;
            sb.append(res);
            if (next == 0) return sb.toString();
            pos.put(inner, sb.length() - 1);
            inner = next;
        }
    }
}
