package binarysearch;

public class VerticalCipher {
    public String[] solve(String s, int k) {
        String[] ret = new String[k];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k; i++) {
            for (int j = i; j < s.length(); j += k) sb.append(s.charAt(j));
            ret[i] = sb.toString();
            sb.setLength(0);
        }

        return ret;
    }
}
