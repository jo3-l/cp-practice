package binarysearch;

public class CompressString {
    public String solve(String s) {
        StringBuilder buf = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            buf.append(c);
            i++;
            while (i < s.length() && s.charAt(i) == c) i++;
        }

        return buf.toString();
    }
}
