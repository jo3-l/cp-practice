package binarysearch;

import java.util.HashSet;
import java.util.Set;

public class CommonWords {
    public int solve(String s0, String s1) {
        Set<String> words = getUniqueWords(s0);

        int n = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= s1.length(); i++) {
            char c = i == s1.length() ? ' ' : s1.charAt(i);
            if (c == ' ' && sb.length() > 0) {
                if (words.remove(sb.toString())) n++;
                sb.setLength(0);
            } else {
                if ('A' <= c && c <= 'Z') c += 32;
                sb.append(c);
            }
        }

        return n;
    }

    private Set<String> getUniqueWords(String s) {
        Set<String> words = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= s.length(); i++) {
            char c = i == s.length() ? ' ' : s.charAt(i);
            if (c == ' ' && sb.length() > 0) {
                String x = sb.toString();
                words.add(x);
                sb.setLength(0);
            } else {
                if ('A' <= c && c <= 'Z') c += 32;
                sb.append(c);
            }
        }

        return words;
    }
}
