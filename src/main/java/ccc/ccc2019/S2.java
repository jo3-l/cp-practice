package ccc.ccc2019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        outer: for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int target = 2 * N;
            for (int j = 2; j <= N; j++) {
                if (isPrime(j) && isPrime(target - j)) {
                    System.out.println(j + " " + (target - j));
                    continue outer;
                }
            }
        }
    }

    private static boolean isPrime(int n) {
        if (n <= 3) return true;
        if ((n & 1) == 0) return false;

        int max = (int) Math.sqrt(n);
        for (int i = 3; i <= max; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
