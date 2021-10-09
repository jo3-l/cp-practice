package ccc.ccc2019;

import java.util.Scanner;

public class J3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numLines = scanner.nextInt();
        scanner.skip("\n");

        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < numLines; i++) {
            String line = scanner.nextLine();
            int pos = 0;
            while (pos < line.length()) {
                if (pos != 0) buffer.append(" ");
                int currentChar = line.charAt(pos);
                int count = 0;
                while (pos < line.length() && line.charAt(pos) == currentChar) {
                    ++count;
                    ++pos;
                }
                buffer.append(count).append(" ").append((char) currentChar);
            }
            System.out.println(buffer.toString());
            buffer.setLength(0);
        }
    }
}
