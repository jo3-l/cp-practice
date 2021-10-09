package ccc.ccc2013;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int W = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        int[] weights = new int[N];
        for (int i = 0; i < N; i++) {
            weights[i] = Integer.parseInt(br.readLine());
        }
        // init sliding window sum
        int cur = 0;
        for (int i = 0; i < Math.min(N, 4); i++) {
            cur += weights[i];
            if (cur > W) {
                System.out.println(i);
                return;
            }
        }
        for (int i = 1, j = 4; i < N; i++, j++) {
            cur -= weights[i - 1];
            if (j < N) cur += weights[j];
            if (cur > W) {
                System.out.println(j);
                return;
            }
        }
        System.out.println(N);
    }
}
