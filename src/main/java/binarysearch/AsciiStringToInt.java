package binarysearch;

public class AsciiStringToInt {
    public int solve(String s) {
        int total = 0;

        StringBuilder buf = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i++);
            if (c < '0' || c > '9') continue;
            buf.append(c);
            while (i < s.length() && ('0' <= (c = s.charAt(i)) && c <= '9')) {
                i++;
                buf.append(c);
            }
            total += Integer.parseInt(buf.toString());
            buf.setLength(0);
        }

        return total;
    }
}
