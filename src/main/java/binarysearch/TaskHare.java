package binarysearch;

import java.util.Arrays;

public class TaskHare {
    public int solve(int[] tasks, int[] people) {
        Arrays.sort(tasks);
        Arrays.sort(people);
        int i = 0;
        int j = 0;
        int n = 0;
        while (i < tasks.length && j < people.length) {
            int tp = tasks[i];
            int pp = people[j];
            if (pp >= tp) {
                i++;
                j++;
                n++;
            } else {
                j++;
            }
        }
        return n;
    }
}
