package binarysearch;

public class LongestCommonPrefix {
    public String solve(String[] words) {
        int l = 0;

        int minL = Integer.MAX_VALUE;
        for (String word : words) minL = Math.min(minL, word.length());

        outer: for (int i = 0; i < minL; i++) {
            char c = words[0].charAt(i);
            for (int j = 1; j < words.length; j++) {
                if (words[j].charAt(i) != c) break outer;
            }
            l++;
        }

        return words[0].substring(0, l);
    }
}
