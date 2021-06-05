package binarysearch;

public class SeatArrangement {
    public boolean solve(int n, int[] seats) {
        int lastOccupied = -2;
        int numFree = 0;
        for (int i = 0; i <= seats.length + 1; i++) {
            if (i == seats.length || (i < seats.length && seats[i] == 0)) continue;
            int available = i - lastOccupied - 1;
            if (available > 2) numFree += (available - 1) >> 1;
            lastOccupied = i;
        }
        return numFree >= n;
    }
}
