package binarysearch;

public class IndexInfiniteString {
    public String solve(String s, int i, int j) {
        int begin = i % s.length();
        int vv = j - i;

        StringBuilder sb = new StringBuilder();
        for (
                int idx = begin, n = 0;
                n < vv;
                idx = ++idx == s.length() ? 0 : idx, n++
        ) {
            sb.append(s.charAt(idx));
        }

        return sb.toString();
    }
}
