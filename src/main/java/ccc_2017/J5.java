package ccc_2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class J5 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int woodCount = Integer.parseInt(reader.readLine());

        int[] availableWood = new int[woodCount];
        StringBuilder buffer = new StringBuilder();
        outer:
        for (int i = 0; i < woodCount; i++) {
            while (true) {
                int c = reader.read();
                if (Character.isDigit(c)) {
                    buffer.append((char) c);
                    continue;
                }
                int len = Integer.parseInt(buffer.toString());
                availableWood[i] = len;
                buffer.setLength(0);
                continue outer;
            }
        }

        // Given N wood, we would have N / 2 boards to work with.
        // As such, we can iterate from [1, floor(N / 2)] backwards until we find we can construct a valid fence.
    }
}
