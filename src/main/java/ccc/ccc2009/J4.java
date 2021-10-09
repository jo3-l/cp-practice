package ccc.ccc2009;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class J4 {
    private static final String[] words = {"WELCOME", "TO", "CCC", "GOOD", "LUCK", "TODAY"};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int width = sc.nextInt();
        int wordIdx = 0;
        while (wordIdx < words.length) {
            if (wordIdx > 0) sb.append('\n');

            int totalWordLengths = 0;
            int lineLength = 0;
            List<String> wordsOnLine = new ArrayList<>();
            while (wordIdx < words.length && lineLength < width) {
                String curWord = words[wordIdx];
                if (!wordsOnLine.isEmpty()) {
                    // not first word, so we need at least one space before
                    lineLength++;
                }
                if (lineLength + curWord.length() > width) break;

                wordsOnLine.add(curWord);
                lineLength += curWord.length();
                totalWordLengths += curWord.length();
                wordIdx++;
            }

            int totalSpaces = width - totalWordLengths;
            if (totalSpaces == 0) {
                // fits perfectly
                sb.append(String.join(".", wordsOnLine));
                continue;
            }

            int gaps = wordsOnLine.size() - 1;
            if (gaps == 0) {
                // only 1 word
                sb.append(wordsOnLine.get(0));
                int numSpaces = width - wordsOnLine.get(0).length();
                for (int i = 0; i < numSpaces; i++) sb.append('.');
                continue;
            }

            int spacesBetween = totalSpaces / gaps;
            int remainder = totalSpaces % gaps;
            sb.append(wordsOnLine.get(0));
            for (int i = 1; i < wordsOnLine.size(); i++) {
                int spaces = i <= remainder ? spacesBetween + 1 : spacesBetween;
                for (int j = 0; j < spaces; j++) sb.append('.');
                sb.append(wordsOnLine.get(i));
            }
        }

        System.out.println(sb);
    }
}
