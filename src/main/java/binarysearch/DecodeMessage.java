package binarysearch;

public class DecodeMessage {
    public int solve(String message) {
        int[] dp = new int[message.length()];
        char f = message.charAt(0);
        if (f <= '0' || f > '9') return 0;
        dp[0] = 1;
        for (int i = 1; i < message.length(); i++) {
            char c = message.charAt(i);
            char p = message.charAt(i - 1);
            if ('1' <= c && c <= '9') {
                if (p == '1' || (p == '2' && c <= '6')) {
                    if (i >= 2) dp[i] += dp[i - 2];
                    else dp[i]++;
                }
                dp[i] += dp[i - 1];
            }
            if (c == '0' && (p == '1' || p == '2')) {
                if (i >= 2) dp[i] += dp[i - 2];
                else dp[i]++;
            }
        }
        return dp[message.length() - 1];
    }
}
