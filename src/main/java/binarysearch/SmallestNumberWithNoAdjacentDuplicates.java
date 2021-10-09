package binarysearch;

public class SmallestNumberWithNoAdjacentDuplicates {
    public String solve(String s) {
        char[] ret = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '?') {
                char prev = i > 0 ? ret[i - 1] : 0;
                char next = i < s.length() - 1 ? ret[i + 1] : 0;
                for (char n = '1'; n <= '3'; n++) {
                    if (n != prev && n != next) {
                        ret[i] = n;
                        break;
                    }
                }
            }
        }
        return new String(ret);
    }
}
