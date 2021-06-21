package binarysearch;

public class TheAuditor {
    public int solve(String s) {
        int n = 0;
        int pow = 1;
        int l = s.length();
        while (l-- > 0) {
            int o = s.charAt(l) - 'A' + 1;
            n += o * pow;
            pow *= 26;
        }
        return n;
    }
}
