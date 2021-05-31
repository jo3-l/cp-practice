package binarysearch;

public class RunLengthDecodedIterator {
    private final String text;
    private int idx = 0;
    private String c = null;
    private int ctr = -1;

    public RunLengthDecodedIterator(String s) {
        text = s;
    }

    public String next() {
        if (ctr <= 0) {
            StringBuilder buf = new StringBuilder();
            for (char c = text.charAt(idx); Character.isDigit(c); c = text.charAt(++idx)) buf.append(c - '0');
            ctr = Integer.parseInt(buf.toString());
            c = text.substring(idx, ++idx);
        }

        ctr--;
        return c;
    }

    public boolean hasnext() {
        return ctr > 0 || idx < text.length();
    }
}
