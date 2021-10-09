package binarysearch;

public class LongestConsecutiveDuplicateString {
    public int solve(String s) {
        int best = 0;
        int i = 0;
        while (i < s.length()) {
            int begin = i;
            char c = s.charAt(i++);
            while (i < s.length() && s.charAt(i) == c) i++;
            best = Math.max(best, i - begin);
        }
        return best;
    }
}
