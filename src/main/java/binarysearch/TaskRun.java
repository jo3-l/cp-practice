package binarysearch;

import java.util.HashMap;
import java.util.Map;

public class TaskRun {
    public int solve(int[] tasks, int k) {
        Map<Integer, Integer> seen = new HashMap<>();
        int time = 0;
        for (int typ : tasks) {
            int last = seen.getOrDefault(typ, Integer.MIN_VALUE);
            if (last > time - k) time = last + k;
            time++;
            seen.put(typ, time);
        }
        return time;
    }
}
