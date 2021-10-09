package ccc.ccc2010;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class S1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PC[] p = new PC[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int r = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            p[i] = new PC(name, (2 * r) + (3 * s) + d);
        }
        Arrays.sort(p, Comparator.comparing((PC pc) -> pc.rating).reversed().thenComparing((PC pc) -> pc.name));
        if (p.length > 0) System.out.println(p[0].name);
        if (p.length > 1) System.out.println(p[1].name);
    }

    private static class PC {
        public String name;
        public int rating;

        public PC(String name, int rating) {
            this.name = name;
            this.rating = rating;
        }
    }
}
