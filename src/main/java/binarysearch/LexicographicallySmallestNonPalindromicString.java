package binarysearch;

public class LexicographicallySmallestNonPalindromicString {
    public String solve(String s) {
        char[] chars = s.toCharArray();
        int midIdx = (chars.length & 1) == 0 ? -1 : chars.length >> 1;
        for (int i = 0; i < chars.length; i++) {
            if (i == midIdx) continue;
            if (i == chars.length - 1 || chars[i] != 'a') {
                chars[i] = chars[i] == 'a' ? 'b' : 'a';
                break;
            }
        }
        return new String(chars);
    }
}
