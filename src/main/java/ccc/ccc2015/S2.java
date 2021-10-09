package ccc.ccc2015;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.BitSet;

public class S2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int J = Integer.parseInt(br.readLine());
        int A = Integer.parseInt(br.readLine());

        int[] jerseys = new int[J + 1];
        for (int i = 1; i <= J; i++) {
            char c = br.readLine().charAt(0);
            jerseys[i] = c == 'S'
                    ? 0
                    : c == 'M'
                    ? 1
                    : 2;
        }

        BitSet used = new BitSet(A + 1);
        int satisfied = 0;
        for (int i = 0; i < A; i++) {
            String s = br.readLine();
            char c = s.charAt(0);
            int size = c == 'S' ? 0 : c == 'M' ? 1 : 2;
            int j = Integer.parseInt(s.substring(2));
            if (!used.get(j) && jerseys[j] >= size) {
                satisfied++;
                used.set(j);
            }
        }
        System.out.println(satisfied);
    }
}
