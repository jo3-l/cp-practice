package ccc.ccc2015;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        int total = 0;
        int[] history = new int[K];
        int idx = 0;
        while (K-- > 0) {
            int i = Integer.parseInt(br.readLine());
            if (i == 0) total -= history[--idx];
            else total += history[idx++] = i;
        }
        System.out.println(total);
    }
}
