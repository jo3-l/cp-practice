package binarysearch;

public class SteadySpeed {
    public int solve(int[] positions) {
        if (positions.length <= 2) return positions.length;

        int lastDelta = Math.abs(positions[1] - positions[0]);
        int cur = 1;
        int max = cur;
        for (int i = 2; i < positions.length; i++) {
            int delta = Math.abs(positions[i] - positions[i - 1]);
            if (lastDelta == delta) {
                cur++;
            } else {
                max = Math.max(max, cur);
                cur = 1;
            }

            lastDelta = delta;
        }

        return Math.max(max, cur) + 1;
    }
}
