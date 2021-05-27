package binarysearch;

public class BalancedBrackets {
    public boolean solve(String s) {
        int depth = 0;
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '(':
                    depth++;
                    break;
                case ')':
                    if (depth-- == 0) return false;
                    break;
            }
        }

        return depth == 0;
    }
}
