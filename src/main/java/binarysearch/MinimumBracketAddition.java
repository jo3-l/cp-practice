package binarysearch;

public class MinimumBracketAddition {
    public int solve(String s) {
        int depth = 0;
        int adjusted = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') depth++;
            else depth--;

            if (depth == -1) {
                depth++;
                adjusted++;
            }
        }

        return adjusted + depth;
    }
}
