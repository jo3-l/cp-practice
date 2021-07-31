package binarysearch;

public class AddBinaryNumbers {
    public String solve(String a, String b) {
        a = pad(a, Math.max(a.length(), b.length()));
        b = pad(b, Math.max(a.length(), b.length()));
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for (int i = b.length() - 1; i >= 0; i--) {
            int x = b.charAt(i) - '0';
            int y = a.charAt(i) - '0';
            int m = x + y + carry;
            sb.append(m & 1);
            carry = m >> 1;
        }
        if (carry != 0) sb.append(carry);
        return sb.reverse().toString();
    }

    private String pad(String s, int len) {
        StringBuilder sb = new StringBuilder();
        int d = len - s.length();
        if (d <= 0) return s;
        while (d-- > 0) sb.append('0');
        return sb.append(s).toString();
    }
}
