package binarysearch;

public class ConsecutiveDuplicates {
    public String solve(String s) {
        if (s.length() < 2) return s;

        StringBuilder sb = new StringBuilder();
        char last = s.charAt(0);
        sb.append(last);
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != last) {
                sb.append(c);
                last = c;
            }
        }

        return sb.toString();
    }
}
