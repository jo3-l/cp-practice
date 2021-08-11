package binarysearch;

public class SocialDistancing {
    public boolean solve(String s, int k) {
        int i;
        for (i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'x') break;
        }
        if (i >= k) return true;

        int j = i;
        while (j < s.length()) {
            int start = j++;
            while (j < s.length() && s.charAt(j) != 'x') j++;
            int dist = j >= s.length()
                    ? s.length() - start - 1
                    : (j - start) >> 1;
            if (dist >= k) return true;
        }
        return false;
    }
}
