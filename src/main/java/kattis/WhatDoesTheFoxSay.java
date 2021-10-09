package kattis;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class WhatDoesTheFoxSay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCaseCount = scanner.nextInt();
        scanner.skip("\n");

        StringBuilder sb = new StringBuilder();
        Set<String> ignoredWords = new HashSet<>();
        for (int i = 0; i < testCaseCount; i++) {
            String[] words = scanner.nextLine().split(" ");

            String data = scanner.nextLine();
            while (!data.equals("what does the fox say?")) {
                String[] parts = data.split(" "); // <animal> goes <word>
                ignoredWords.add(parts[parts.length - 1]);
                data = scanner.nextLine();
            }

            boolean isFirst = true;
            for (String word : words) {
                if (ignoredWords.contains(word)) continue;
                if (!isFirst) sb.append(" ");
                sb.append(word);

                if (isFirst) isFirst = false;
            }
            System.out.println(sb.toString());

            sb.setLength(0);
            ignoredWords.clear();
        }
    }
}
