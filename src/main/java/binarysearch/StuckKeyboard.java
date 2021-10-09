package binarysearch;

public class StuckKeyboard {
    public boolean solve(String typed, String target) {
        if (typed.length() < target.length()) return false;

        int k = 0;
        int i = 0;
        while (i < target.length()) {
            char c = target.charAt(i);
            int o = k;
            while (k < typed.length() && typed.charAt(k) == c) k++;

            int consumed = k - o;
            if (consumed == 0) return false;

            int max = Math.min(i + consumed, target.length());

            i++;
            while (i < max && target.charAt(i) == c) i++;
        }

        return k == typed.length();
    }
}
