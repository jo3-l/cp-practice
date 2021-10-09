package binarysearch;

import java.util.ArrayList;
import java.util.List;

public class NarcissisticNumber {
    public boolean solve(int n) {
        int mark = n;
        List<Integer> digits = new ArrayList<>();
        while (n >= 10) {
            digits.add(n % 10);
            n /= 10;
        }
        digits.add(n % 10);
        return digits.stream().mapToInt(v -> (int) Math.pow(v, digits.size())).sum() == mark;
    }
}
