package binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JustifyText {
    public String[] solve(String[] words, int k) {
        int wordIdx = 0;
        List<String> lines = new ArrayList<>();
        while (wordIdx < words.length) {
            int totalWordLength = 0;
            int lineLength = 0; // takes the constraint that there must be at least 1 space between words into account
            int maxWordIdx = wordIdx;
            while (maxWordIdx < words.length && lineLength < k) {
                System.out.println(maxWordIdx);
                String word = words[maxWordIdx];
                if (maxWordIdx != wordIdx) {
                    // not the first word in this line; we need a space.
                    lineLength++;
                }
                if (lineLength + word.length() > k) break;

                maxWordIdx++;
                lineLength += word.length();
                totalWordLength += word.length();
            }

            int totalSpacesNeeded = k - totalWordLength;
            if (totalSpacesNeeded == 0) {
                StringBuilder sb = new StringBuilder();
                for (int i = wordIdx; i < maxWordIdx; i++) {
                    if (i != wordIdx) sb.append(' ');
                    sb.append(words[i]);
                }

                // fits perfectly
                lines.add(sb.toString());
                wordIdx = maxWordIdx;
                continue;
            }

            int gaps = maxWordIdx - wordIdx - 1;
            if (gaps == 0) {
                // only one word
                StringBuilder sb = new StringBuilder(words[wordIdx]);
                for (int i = 0; i < totalSpacesNeeded; i++) sb.append(' ');
                lines.add(sb.toString());
                wordIdx = maxWordIdx;
                continue;
            }

            int spacesPerGap = totalSpacesNeeded / gaps;
            int leftover = totalSpacesNeeded % gaps;

            StringBuilder sb = new StringBuilder();
            for (int i = wordIdx; i < maxWordIdx; i++) {
                int spaces = i <= wordIdx + leftover ? spacesPerGap + 1 : spacesPerGap;
                if (i != wordIdx) {
                    for (int j = 0; j < spaces; j++) sb.append(' ');
                }
                sb.append(words[i]);
            }
            lines.add(sb.toString());
            wordIdx = maxWordIdx;
        }

        String[] ret = new String[lines.size()];
        for (int i = 0; i < lines.size(); i++) ret[i] = lines.get(i);
        return ret;
    }
}
