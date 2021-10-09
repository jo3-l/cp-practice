package binarysearch;

public class TargetNumberWithOperations {
    public int solve(int start, int end) {
        int d = start << 1;
        int op;
        for (op = 0; start < end; op++) {
            if ((end & 1) == 1 || end < d) end--;
            else end >>= 1;
        }
        return op;
    }
}
