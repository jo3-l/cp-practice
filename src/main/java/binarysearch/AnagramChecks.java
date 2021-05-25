package binarysearch;

public class AnagramChecks {
    public boolean solve(String s0, String s1) {
        if (s0.length() != s1.length()) return false;

        int[] freq0 = new int[26];
        int[] freq1 = new int[26];
        for (int i = 0; i < s0.length(); i++) {
            freq0[s0.charAt(i) - 'a']++;
            freq1[s1.charAt(i) - 'a']++;
        }

        for (int i = 0; i < freq0.length; i++) {
            if (freq0[i] != freq1[i]) return false;
        }
        return true;
    }
}
