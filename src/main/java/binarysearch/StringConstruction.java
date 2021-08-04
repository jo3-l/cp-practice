package binarysearch;

public class StringConstruction {
    public int solve(String[] strings, int a, int b) {
        int[][][] dp = new int[strings.length][a + 1][b + 1];
        int max = 0;
        for (int i = 0; i < strings.length; i++) {
            int[] counts = new int[2];
            for (int j = 0; j < strings[i].length(); j++) counts[strings[i].charAt(j) - 'A']++;
            for (int ax = 0; ax <= a; ax++) {
                for (int bx = 0; bx <= b; bx++) {
                    dp[i][ax][bx] = i > 0 ? dp[i - 1][ax][bx] : 0;
                    if (ax >= counts[0] && bx >= counts[1]) {
                        dp[i][ax][bx] = Math.max(dp[i][ax][bx], i > 0 ? dp[i - 1][ax - counts[0]][bx - counts[1]] + 1 : 1);
                    }
                    max = Math.max(max, dp[i][ax][bx]);
                }
            }
        }
        return max;
    }
}
