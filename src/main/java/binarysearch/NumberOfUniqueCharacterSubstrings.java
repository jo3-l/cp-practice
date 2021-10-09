package binarysearch;

public class NumberOfUniqueCharacterSubstrings {
    public int solve(String s) {
        int t = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) t++;
                else break;
            }
        }
        return t;
    }
}
