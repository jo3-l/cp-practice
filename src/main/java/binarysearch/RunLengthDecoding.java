package binarysearch;

public class RunLengthDecoding {
    public String solve(String s) {
        StringBuilder buf = new StringBuilder();
        StringBuilder res = new StringBuilder();

        int i = 0;
        while (i < s.length()) {
            while (Character.isDigit(s.charAt(i))) {
                buf.append(s.charAt(i));
                i++;
            }
            int rep = Integer.parseInt(buf.toString());
            buf.setLength(0);

            char c = s.charAt(i);
            for (int j = 0; j < rep; j++) res.append(c);
            i++;
        }

        return res.toString();
    }
}
