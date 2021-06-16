package binarysearch;

import java.util.ArrayList;
import java.util.List;

public class PhoneNumberCombos {
    private final String[] keypad = new String[]{
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz",
    };

    public String[] solve(String digits) {
        if (digits.isEmpty()) return null;
        List<char[]> res = new ArrayList<>();
        String m = keypad[digits.charAt(0) - '2'];

        for (int i = 0; i < m.length(); i++) {
            char c = m.charAt(i);
            char[] s = new char[digits.length()];
            s[0] = c;
            res.add(s);
        }

        for (int i = 1; i < digits.length(); i++) {
            m = keypad[digits.charAt(i) - '2'];
            List<char[]> next = new ArrayList<>(res.size() * m.length());
            for (char[] old : res) {
                for (int j = 0; j < m.length(); j++) {
                    char c = m.charAt(j);
                    char[] clone = new char[digits.length()];
                    System.arraycopy(old, 0, clone, 0, old.length);
                    clone[i] = c;
                    next.add(clone);
                }
            }
            res = next;
        }

        String[] ret = new String[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ret[i] = new String(res.get(i));
        }
        return ret;
    }
}
