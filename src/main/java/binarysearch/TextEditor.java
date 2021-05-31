package binarysearch;

public class TextEditor {
    public String solve(String s) {
        StringBuilder res = new StringBuilder();

        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (c == '<' && i != s.length() - 1) {
                char nc = s.charAt(i + 1);
                if (nc == '-') {
                    if (res.length() > 0) res.deleteCharAt(res.length() - 1);
                    i += 2;
                    continue;
                }
            }

            res.append(c);
            i++;
        }

        return res.toString();
    }
}
