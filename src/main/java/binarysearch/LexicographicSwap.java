package binarysearch;

public class LexicographicSwap {
    public String solve(String s) {
        // dp[i] = index of the lowest character that can be found right of i (inclusive).
        // if there are two lowest characters, the one with the higher index is chosen.
        int[] dp = new int[s.length()];
        dp[s.length() - 1] = s.length() - 1;
        for (int i = s.length() - 2; i >= 0; i--) {
            if (s.charAt(i) < s.charAt(dp[i + 1])) dp[i] = i;
            else dp[i] = dp[i + 1];
        }

        char[] m = s.toCharArray();
        for (int i = 0; i < m.length; i++) {
            int j = dp[i];
            if (m[i] > m[j]) {
                char tmp = m[i];
                m[i] = m[j];
                m[j] = tmp;
                break;
            }
        }
        return new String(m);
    }
}
