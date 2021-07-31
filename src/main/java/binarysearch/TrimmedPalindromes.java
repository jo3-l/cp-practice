package binarysearch;

public class TrimmedPalindromes {
    public int solve(String s) {
        int n = s.length(); // 1 length palindromes

        // odd length
        for (int center = 1; center < s.length() - 1; center++) {
            for (int k = 1; k < s.length(); k++) {
                int b = center - k;
                int e = center + k;
                if (b < 0 || e >= s.length()) break;
                if (s.charAt(b) == s.charAt(e)) n++;
                else break;
            }
        }

        // even length
        for (int l = 0, r = 1; r < s.length(); l++, r++) {
            for (int k = 0; k < s.length(); k++) {
                int b = l - k;
                int e = r + k;
                if (b < 0 || e >= s.length()) break;
                if (s.charAt(b) == s.charAt(e)) n++;
                else break;
            }
        }
        return n;
    }
}
