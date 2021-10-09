package ccc.ccc2011;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] correct = new int[N];
        for (int i = 0; i < N; i++) {
            correct[i] = br.read();
            br.skip(1); // '\n'
        }
        int c = 0;
        for (int i = 0; i < N; i++) {
            if (correct[i] == br.read()) c++;
            br.skip(1); // '\n'
        }
        System.out.println(c);
    }
}
