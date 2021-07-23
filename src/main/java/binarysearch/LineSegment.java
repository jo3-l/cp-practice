package binarysearch;

public class LineSegment {
    public boolean solve(int[][] coordinates) {
        if (coordinates.length < 2) return false;
        int[] c0 = coordinates[0];
        int[] c1 = coordinates[1];
        double slope = (double) (c0[1] - c1[1]) / (c0[0] - c1[0]);
        for (int i = 2; i < coordinates.length; i++) {
            int[] pc = coordinates[i - 1];
            int[] cc = coordinates[i];
            double c = (double) (pc[1] - cc[1]) / (pc[0] - cc[0]);
            if (c != slope) return false;
        }
        return true;
    }
}
