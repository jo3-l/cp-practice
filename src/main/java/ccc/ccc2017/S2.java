package ccc.ccc2017;

import java.util.Arrays;
import java.util.Scanner;

public class S2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] measurements = new int[N];
        for (int i = 0; i < N; i++) measurements[i] = sc.nextInt();
        Arrays.sort(measurements);
        // consider:
        // (elements) 2 3 7 10 40 50 90 110
        // (indices)  0 1 2 3  4  5  6  7
        // (length)   8
        // low tides begin at length/2.
        boolean needSpace = false;
        int i = (N - 1) >> 1;
        int j = i + 1;
        while (i >= 0 || j < N) {
            if (needSpace) System.out.print(" ");
            else needSpace = true;
            boolean hasLow = i >= 0;
            if (hasLow) System.out.print(measurements[i--]);
            if (j < N) {
                if (hasLow) System.out.print(" ");
                System.out.print(measurements[j++]);
            }
        }
    }
}
