package binarysearch;

public class ClusterManagement {
    public boolean solve(int[] cores, int[] tasks) {
        for (int i = 0; i < cores.length; i++) {
            boolean ok = go(cores, tasks, i, cores[i], 0);
            if (ok) return true;
        }
        return cores.length == 0 && tasks.length == 0;
    }

    private boolean go(int[] cores, int[] tasks, int i, int capacity, int doneTasks) {
        if (doneTasks == (1 << tasks.length) - 1) return true;
        if (i >= cores.length) return false;
        for (int t = 0; t < tasks.length; t++) {
            if ((doneTasks & (1 << t)) == 0) {
                if (capacity >= tasks[t]) {
                    boolean ok = go(cores, tasks, i, capacity - tasks[t], doneTasks | (1 << t))
                            || (i < cores.length - 1
                            && go(cores, tasks, i + 1, cores[i + 1], doneTasks | (1 << t)));
                    if (ok) return true;
                }
            }
        }
        return false;
    }
}
