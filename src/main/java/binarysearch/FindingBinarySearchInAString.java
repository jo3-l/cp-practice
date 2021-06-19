package binarysearch;

public class FindingBinarySearchInAString {
    private final char[] expect = "inarysearch".toCharArray();

    public boolean solve(String s) {
        for (int bIdx = 0; bIdx < s.length() - 10 /* len("binarysearch") - 1 */; bIdx++) {
            if (s.charAt(bIdx) != 'b') continue;
            int max = (s.length() - bIdx) / 11 /* len("binarysearch") */;
            outer: for (int j = 1; j <= max; j++) {
                int offset = 0;
                for (int i = bIdx + j; offset != expect.length && i < s.length(); i += j) {
                    if (s.charAt(i) != expect[offset++]) continue outer;
                }
                if (offset == expect.length) return true;
            }
        }
        return false;
    }
}
