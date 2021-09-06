package binarysearch;

public class VerticalWordArrangement {
    public String[] solve(String s) {
        int m = 0;
        String[] lines = s.split(" ");
        for (String v : lines) m = Math.max(m, v.length());
        String[] res = new String[m];
        for (int c = 0; c < m; c++) {
            char[] b = new char[lines.length];
            for (int i = 0; i < lines.length; i++) {
                String l = lines[i];
                b[i] = c < l.length() ? l.charAt(c) : ' ';
            }
            int j;
            for (j = lines.length - 1; j >= 0; j--) {
                if (b[j] != ' ') break;
            }
            res[c] = new String(b, 0, j + 1);
        }
        return res;
    }
}
