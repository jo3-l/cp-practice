package binarysearch;

public class LongestAlliteration {
    public int solve(String[] words) {
        int best = 0;
        int cur = 0;
        char start = 0;
        for (String word : words) {
            char c = word.charAt(0);
            if (c != start) {
                if (cur > best) best = cur;
                cur = 1;
                start = c;
            } else {
                cur++;
            }
        }

        return Math.max(cur, best);
    }
}
