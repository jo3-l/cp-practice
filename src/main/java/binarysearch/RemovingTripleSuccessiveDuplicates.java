package binarysearch;

public class RemovingTripleSuccessiveDuplicates {
    public int solve(String s) {
        char[] xs = s.toCharArray();
        int N = xs.length;
        int j = 0;
        int i = 0;
        while (i < N) {
            char c = s.charAt(i++);
            int seen = 1;
            while (i < N && s.charAt(i) == c) {
                if (++seen == 3) {
                    seen = 0;
                    xs[i] = (char) ('0' + (s.charAt(i) - '0') ^ 1);
                    j++;
                }
                i++;
            }
        }
        return j;
    }
}
