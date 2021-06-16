package binarysearch;

import java.util.Arrays;

public class RocketshipRescue {
    public int solve(int[] weights, int limit) {
        if (weights.length == 1) return 1;

        Arrays.sort(weights);
        int high = weights.length - 1;
        int low = 0;

        int skip = 0;
        int ships = 0;
        while (low < high) {
            if (weights[low] + weights[high] > limit) {
                high--;
                skip++;
            } else {
                low++;
                high--;
                ships++;
            }
        }

        ships += skip;
        if (low == 0) ships++;
        else if (low == high) ships++;
        return ships;
    }
}
