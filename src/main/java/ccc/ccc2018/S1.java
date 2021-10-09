package ccc.ccc2018;

import java.util.Arrays;
import java.util.Scanner;

public class S1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] villages = new int[N];
        for (int i = 0; i < N; i++) {
            villages[i] = sc.nextInt();
        }
        Arrays.sort(villages);

        double smallest = Double.MAX_VALUE;
        for (int i = 1; i < N - 1; i++) {
            int prev = villages[i - 1];
            int cur = villages[i];
            int next = villages[i + 1];

            double size = (((double) cur - prev) / 2) + (((double) next - cur) / 2);
            if (size < smallest) smallest = size;
        }

        System.out.printf("%.1f\n", smallest);
    }
}
