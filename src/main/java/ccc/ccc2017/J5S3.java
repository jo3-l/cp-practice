package ccc.ccc2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class J5S3 {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(r.readLine());
        int[] buckets = new int[2001]; // index n with value v means that there are v instances of the number n in the input

        StringBuilder buf = new StringBuilder();
        for (int i = 0; i < N; i++) {
            // consume next number
            for (int c = r.read(); c != -1 && Character.isDigit(c); c = r.read()) buf.append((char) c);
            int length = Integer.parseInt(buf.toString());
            buckets[length]++;
            // reset buf
            buf.setLength(0);
        }

        int[] totals = new int[4001]; // index n with value v means that there are v pairs with total n
        for (int first = 1; first <= 2000; first++) {
            int firstCount = buckets[first];
            if (firstCount == 0) continue; // first number is not present

            if (firstCount >= 2) {
                totals[first + first] += firstCount / 2;
            }

            for (int second = first + 1; second <= 2000; second++) {
                int secondCount = buckets[second];
                if (secondCount == 0) continue;
                totals[first + second] += Math.min(firstCount, secondCount);
            }
        }

        int best = -1;
        int count = 0;
        for (int n = 2; n <= 4000; n++) {
            int numPairs = totals[n];
            if (numPairs == 0) continue;
            if (numPairs > best) {
                best = numPairs;
                count = 1;
            } else if (numPairs == best) {
                count++;
            }
        }
        System.out.println(best + " " + count);
    }
}
