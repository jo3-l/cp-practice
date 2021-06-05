package ccc.ccc2020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class S1 {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(r.readLine());

        Pair[] pairs = new Pair[N];
        for (int i = 0; i < N; i++) {
            String[] parts = r.readLine().split(" ");
            Pair p = new Pair(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
            pairs[i] = p;
        }

        Arrays.sort(pairs, Comparator.comparing(v -> v.time));

        Pair last = pairs[0];
        double max = -1;
        for (int i = 1; i < pairs.length; i++) {
            Pair p = pairs[i];
            double speed = Math.abs((double) p.position - last.position) / (p.time - last.time);
            if (speed > max) max = speed;
            last = p;
        }

        System.out.println(max);
    }

    private static class Pair {
        public int time;
        public int position;

        public Pair(int time, int position) {
            this.time = time;
            this.position = position;
        }
    }
}
