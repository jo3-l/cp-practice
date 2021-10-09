package binarysearch;

public class RemovingParens {
    public int solve(String s) {
        int depth = 0;
        int rm = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                depth++;
            } else {
                if (depth == 0) rm++;
                else depth--;
            }
        }
        return rm + depth;
    }
}
