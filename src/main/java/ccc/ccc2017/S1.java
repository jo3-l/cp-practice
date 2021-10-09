package ccc.ccc2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        int[] swifts = read(br, N, sb);
        int[] sephamores = read(br, N, sb);
        while (N-- > 0) {
            if (swifts[N] == sephamores[N]) break;
        }
        System.out.println(N + 1);
    }

    private static int[] read(BufferedReader br, int n, StringBuilder buf) throws IOException {
        int[] ret = new int[n];
        for (int i = 0; i < n; i++) {
            for (int c = br.read(); '0' <= c && c <= '9'; c = br.read()) buf.append((char) c);
            ret[i] = Integer.parseInt(buf.toString());
            if (i != 0) ret[i] += ret[i - 1];
            buf.setLength(0);
        }
        return ret;
    }
}
