package binarysearch;

public class PalindromicAnagram {
    public boolean solve(String s) {
        int[] counts = new int[52];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'a') {
                counts[c - 'a']++;
            } else {
                counts[c - 'A' + 26]++;
            }
        }

        int odd = 0;
        for (int c : counts) {
            odd += c & 1;
            if (odd > 1) return false;
        }

        return true;
    }
}
