package binarysearch;

public class ShortestString {
    public int solve(String s) {
        if (s.length() < 2) return s.length();
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (sb.length() > 0 && sb.charAt(sb.length() - 1) != c) {
                sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.append(c);
            }
        }
        return sb.length();
    }
}
