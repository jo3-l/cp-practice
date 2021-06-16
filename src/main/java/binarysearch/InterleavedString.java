package binarysearch;

public class InterleavedString {
    public String solve(String s0, String s1) {
        StringBuilder sb = new StringBuilder(s0.length() + s1.length());
        int i;
        for (i = 0; i < Math.min(s0.length(), s1.length()); i++) {
            sb.append(s0.charAt(i));
            sb.append(s1.charAt(i));
        }
        if (s0.length() > s1.length()) {
            for (; i < s0.length(); i++) sb.append(s0.charAt(i));
        } else if (s1.length() > s0.length()) {
            for (; i < s1.length(); i++) sb.append(s1.charAt(i));
        }
        return sb.toString();
    }
}
