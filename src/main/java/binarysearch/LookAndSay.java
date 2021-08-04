package binarysearch;

public class LookAndSay {
    private final String[] known = {"", "1", "11", "21"};

    public String solve(int n) {
        if (n < known.length) return known[n];
        String[] seq = new String[n + 1];
        System.arraycopy(known, 0, seq, 0, known.length);
        for (int i = 4; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            String prev = seq[i - 1];
            int j = 0;
            while (j < prev.length()) {
                int mark = j;
                char b = prev.charAt(j++);
                while (j < prev.length() && prev.charAt(j) == b) j++;
                sb.append(j - mark);
                sb.append(b);
            }
            seq[i] = sb.toString();
        }
        return seq[n];
    }
}
