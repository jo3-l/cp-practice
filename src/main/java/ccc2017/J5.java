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
        for (int i = 0; i < woodCount; i++) {
            for (int c = reader.read(); Character.isDigit(c); c = reader.read()) buffer.append((char) c);
            int len = Integer.parseInt(buffer.toString());
            woodLengths[i] = len;
            buffer.setLength(0);
        }
    }
}
