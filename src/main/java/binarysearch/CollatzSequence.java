package binarysearch;

public class CollatzSequence {
    public int solve(int n) {
        int count = 1;
        while (n != 1) {
            count++;

            n = (n & 1) == 0 ? n >> 1 : 3 * n + 1;
            if ((n & (n - 1)) == 0) {
                count += 31 - Integer.numberOfLeadingZeros(n); // log2(n)
                break;
            }
        }

        return count;
    }
}
