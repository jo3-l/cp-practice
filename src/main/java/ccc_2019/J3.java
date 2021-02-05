package ccc_2019;

import java.util.ArrayList;
import java.util.Scanner;

// This solution somehow?? fails on the CCC online grader but works on DMOJ. I've also tried using some other answers and they all fail on that particular test case so...
public class J3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numLines = scanner.nextInt();
        scanner.skip("\n");

        ArrayList<String> encodedLines = new ArrayList<>();
        for (int i = 0; i < numLines; i++) {
            String line = scanner.nextLine();
            int pos = 0;
            ArrayList<String> encodedPairs = new ArrayList<>();
            while (pos < line.length()) {
                int currentChar = line.charAt(pos);
                int count = 0;
                while (pos < line.length() && line.charAt(pos) == currentChar) {
                    ++count;
                    ++pos;
                }
                encodedPairs.add(count + " " + ((char) currentChar));
            }
            encodedLines.add(String.join(" ", encodedPairs));
        }

        encodedLines.forEach(System.out::println);
    }
}
