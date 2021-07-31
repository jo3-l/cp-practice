package binarysearch;

public class MaximizeSocialDistancing {
    public int solve(int[] seats) {
        int i = 0;
        int lastOccupied = -1;
        int res = 0;
        while (i < seats.length) {
            if (seats[i] == 0) {
                i++;
                continue;
            }
            res = Math.max(res, lastOccupied == -1 ? i : (i - lastOccupied) >> 1);

            int j = i + 1;
            while (j < seats.length && seats[j] == 0) j++;
            lastOccupied = j - 1;
            res = Math.max(res, j >= seats.length ? j - i - 1 : (j - i) >> 1);

            i = j;
        }

        return res;
    }
}
