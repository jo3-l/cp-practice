package binarysearch;

public class BlocksToSpellWord {
    public boolean solve(String[] words, String target) {
        int[] charsets = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            String s = words[i];
            for (int j = 0; j < s.length(); j++) charsets[i] |= 1 << (s.charAt(j) - 'a');
        }

        // dp(i, j) is whether the subset of target specified by i can be made using words[:j]
        boolean[][] dp = new boolean[1 << target.length()][words.length];
        dp[0][0] = true;
        for (int i = 0; i < (1 << target.length()); i++) {
            outer: for (int j = 0; j < words.length; j++) {
                if (j > 0) dp[i][j] = dp[i][j - 1];
                if (dp[i][j]) continue outer;
                for (int w = 0; w < target.length(); w++) {
                    if ((i & (1 << w)) != 0) {
                        int c = target.charAt(w) - 'a';
                        if ((charsets[j] & (1 << c)) != 0) {
                            int before = i & ~(1 << w);
                            dp[i][j] = (j == 0 && before == 0) || (j > 0 && dp[before][j - 1]);
                            if (dp[i][j]) continue outer;
                        }
                    }
                }
            }
        }

        return dp[(1 << target.length()) - 1][words.length - 1];
    }
}
