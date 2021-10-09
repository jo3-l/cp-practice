package binarysearch;

public class ShortestMajoritySubstring {
    public int solve(String s) {
        int ans = 4;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) return 2;
            if (i < s.length() - 2) {
                char a = s.charAt(i);
                char b = s.charAt(i + 1);
                char c = s.charAt(i + 2);
                if (a == b || a == c || b == c) ans = Math.min(ans, 3);
            }
        }
        return ans == 4 ? -1 : ans;
    }
}
