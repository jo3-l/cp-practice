package binarysearch;

public class FirstFitRoom {
    public int solve(int[] rooms, int target) {
        for (int room : rooms) {
            if (room >= target) return room;
        }
        return -1;
    }
}
