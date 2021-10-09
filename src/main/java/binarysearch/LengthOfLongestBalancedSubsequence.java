package binarysearch;

public class LengthOfLongestBalancedSubsequence {
    public int solve(String s) {
        int depth = 0;
        int l = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || depth > 0) {
                if (c == '(') depth++;
                else depth--;
                l++;
            }
        }
        return depth > 0 ? l - depth : l;
    }
}
