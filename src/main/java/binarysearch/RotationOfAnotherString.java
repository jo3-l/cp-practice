package binarysearch;

public class RotationOfAnotherString {
    private final int P = 31;

    public boolean solve(String s0, String s1) {
        if (s0.length() != s1.length()) return false;
        if (s0.isEmpty()) return true;
        Info i0 = getInfo(s0);
        Info i1 = getInfo(s1);
        for (int lo = 0, hi = s0.length() - 1; lo < s0.length(); lo++, hi--) {
            if (i0.fwdhsh[lo] == i1.bkwhsh[hi]
                    && (lo == s0.length() - 1 || i0.bkwhsh[lo + 1] == i1.fwdhsh[hi - 1])) {
                return true;
            }
        }
        return false;
    }

    private Info getInfo(String s) {
        Info i = new Info();
        i.fwdhsh = new int[s.length()];
        i.fwdhsh[0] = s.charAt(0);
        i.bkwhsh = new int[s.length()];
        i.bkwhsh[s.length() - 1] = s.charAt(s.length() - 1);
        int m = 1;
        for (int lo = 1, hi = s.length() - 2; lo < s.length(); lo++, hi--) {
            i.fwdhsh[lo] = i.fwdhsh[lo - 1] * P + s.charAt(lo);
            i.bkwhsh[hi] = i.bkwhsh[hi + 1] + (s.charAt(hi) * (m *= P));
        }
        return i;
    }

    private static class Info {
        public int[] fwdhsh; // i => hash(str[..i])
        public int[] bkwhsh; // i => hash(str[i..])
    }
}
