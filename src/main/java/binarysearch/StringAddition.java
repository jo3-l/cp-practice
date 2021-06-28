package binarysearch;

public class StringAddition {
    public String solve(String a, String b) {
        StringBuilder sb = new StringBuilder();
        // pad
        int len = Math.max(a.length(), b.length());
        a = pad(a, len);
        b = pad(b, len);

        int carry = 0;
        for (int i = a.length() - 1; i >= 0; i--) {
            int av = a.charAt(i) - '0';
            int bv = b.charAt(i) - '0';
            int val = av + bv + carry;
            if (val >= 10) {
                val -= 10;
                carry = 1;
            } else {
                carry = 0;
            }
            sb.append(val);
        }
        if (carry != 0) sb.append(carry);
        return sb.reverse().toString();
    }

    private String pad(String s, int len) {
        int need = len - s.length();
        if (need == 0) return s;
        char[] padded = new char[len];
        for (int i = 0; i < len; i++) padded[i] = i < need ? '0' : s.charAt(i - need);
        return new String(padded);
    }
}
