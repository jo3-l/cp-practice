package ccc_2019;

import java.util.Scanner;

// This solution somehow?? fails on the CCC online grader but works on DMOJ. I've also tried using some other answers and
// they all fail on that particular test case so... Going to assume this is an issue with the CCC online grader.
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
                // Add a leading space if not at the first index.
                if (pos != 0) buffer.append(" ");
                int currentChar = line.charAt(pos);
                int count = 0;
                // While we're not out of range and the character is equal to the starting character...
                while (pos < line.length() && line.charAt(pos) == currentChar) {
                    // Then increment the number of times the character was repeated and our index in the string.
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
