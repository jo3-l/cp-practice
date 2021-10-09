package binarysearch;

public class CreatePalindromeAfterDeletingAtMostKCharacters {
    public boolean solve(String s, int k) {
        if (s.isEmpty()) return true;
        int[][] dp = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(s.length() - j - 1)) {
                    dp[i][j] = (i > 0 && j > 0 ? dp[i - 1][j - 1] : 0) + 1;
                } else {
                    dp[i][j] = Math.max(i > 0 ? dp[i - 1][j] : 0, j > 0 ? dp[i][j - 1] : 0);
                }
            }
        }
        return dp[s.length() - 1][s.length() - 1] + k >= s.length();
    }
}
