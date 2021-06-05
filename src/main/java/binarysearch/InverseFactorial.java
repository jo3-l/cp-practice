package binarysearch;

public class InverseFactorial {
    public int solve(int a) {
        if (a == 2) return 2;

        int max = a >> 1;
        int cur = 1;

        for (int j = 1; j <= max; j++) {
            cur *= j;
            if (cur == a) return j;
        }
        return -1;
    }
}
