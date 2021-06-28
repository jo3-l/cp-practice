package binarysearch;

public class StringExpansion {
    public String solve(String s) {
        StringBuilder ret = new StringBuilder();
        expand(s, ret);
        return ret.toString();
    }

    private void expand(String s, StringBuilder buf) {
        StringBuilder partBuf = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i++);
            if ('a' <= c && c <= 'z') {
                buf.append(c);
                continue;
            }

            // compute number of times we need to reverse
            int times = c - '0';
            while (i < s.length() && '0' <= (c = s.charAt(i)) && c <= '9') {
                times *= 10;
                times += c - '0';
                i++;
            }

            // we're on a ( now, skip it
            i++;

            // parse inner expr
            int depth = 0;
            boolean nested = false;
            while (i < s.length()) {
                char cc = s.charAt(i++);
                if (cc == '(') {
                    depth++;
                    nested = true;
                } else if (cc == ')') {
                    if (depth-- == 0) break;
                }
                partBuf.append(cc);
            }

            // expand
            while (times-- > 0) {
                if (nested) expand(partBuf.toString(), buf);
                else buf.append(partBuf);
            }
            partBuf.setLength(0);
        }
    }
}
