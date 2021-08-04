package binarysearch;

public class MonotonousStringGroups {
    public int solve(String s) {
        int n = 0;
        int i = 0;
        while (i < s.length()) {
            if (i == s.length() - 1) {
                n++;
                break;
            }
            // skip past runs of the same character
            int j = i + 1;
            while (j < s.length() && s.charAt(j) == s.charAt(i)) j++;
            if (j >= s.length()) {
                n++;
                break;
            }

            if (s.charAt(j) < s.charAt(i)) {
                // maximize length of a non-increasing sequence.
                j++;
                while (j < s.length() && s.charAt(j) <= s.charAt(j - 1)) j++;
            } else {
                // maximize length of a non-decreasing sequence.
                j++;
                while (j < s.length() && s.charAt(j) >= s.charAt(j - 1)) j++;
            }

            i = j;
            n++;
        }

        return n;
    }
}
