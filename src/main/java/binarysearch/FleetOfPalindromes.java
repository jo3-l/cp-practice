package binarysearch;

public class FleetOfPalindromes {
    public boolean solve(String s, int k) {
        if (k >= s.length()) return k == s.length();
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }
        int odds = 0;
        for (int f : freq) odds += f & 1;
        return odds <= k;
    }
}
