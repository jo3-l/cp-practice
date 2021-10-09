package binarysearch;

public class CourseScheduling {
    public boolean solve(int[][] courses) {
        int done = 0;
        while (done != courses.length) {
            int mark = done;
            for (int i = 0; i < courses.length; i++) {
                int[] reqs = courses[i];
                if (reqs != null) {
                    int j;
                    for (j = 0; j < reqs.length; j++) {
                        if (courses[reqs[j]] != null) break;
                    }
                    if (j >= reqs.length) {
                        courses[i] = null;
                        done++;
                    }
                }
            }
            if (done == mark) break;
        }
        return done == courses.length;
    }
}
