package binarysearch;

public class MinimumDistanceOfWords {
    public int solve(String text, String word0, String word1) {
        StringBuilder buf = new StringBuilder();

        int best = -1;
        int cur = 0;
        String close = null;
        for (int i = 0; i <= text.length(); i++) {
            char c = i == text.length() ? ' ' : text.charAt(i);
            if (c != ' ') {
                buf.append(c);
                continue;
            }

            String w = buf.toString();
            buf.setLength(0);

            boolean isW0 = w.equals(word0);
            boolean isW1 = w.equals(word1);
            if (close != null) {
                if (w.equals(close)) {
                    if (best == -1 || cur < best) best = cur;
                    cur = 0;
                    close = null;
                } else if (isW0 || isW1) {
                    cur = 0;
                } else {
                    cur++;
                }
            } else if (isW1) {
                close = word0;
            } else if (isW0) {
                close = word1;
            }
        }

        return best;
    }
}
