package ccc2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class J5 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int woodCount = Integer.parseInt(reader.readLine());

        int[] woodLengths = new int[woodCount];
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
                woodLengths[i] = len;
                buffer.setLength(0);
                continue outer;
            }
        }
    }
}
