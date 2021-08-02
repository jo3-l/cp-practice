package binarysearch;

public class LongestPalindromicSubstring {
    public int solve(String s) {
        if (s.isEmpty()) return 0;
        int max = 1; // 1 length substrings always exist
        // odd length
        for (int center = 1; center < s.length() - 1; center++) {
            for (int k = 1; k < s.length(); k++) {
                int lo = center - k;
                int hi = center + k;
                if (lo < 0 || hi >= s.length() || s.charAt(lo) != s.charAt(hi)) break;
                max = Math.max(max, (k << 1) + 1);
            }
        }

        // even length
        for (int i = 0, j = 1; j < s.length(); i++, j++) {
            for (int k = 0; k < s.length(); k++) {
                int lo = i - k;
                int hi = j + k;
                if (lo < 0 || hi >= s.length() || s.charAt(lo) != s.charAt(hi)) break;
                max = Math.max(max, ((k + 1) << 1));
            }
        }
        return max;
    }
}
