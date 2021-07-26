package binarysearch;

public class BulkShiftLetters {
    public String solve(String s, int[] shifts) {
        for (int i = shifts.length - 2; i >= 0; i--) {
            shifts[i] += shifts[i + 1];
            shifts[i] %= 26;
        }
        char[] res = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            int offset = s.charAt(i) - 'a';
            if (i < shifts.length) offset += shifts[i];
            offset %= 26;
            res[i] = (char) ('a' + offset);
        }
        return new String(res);
    }
}
