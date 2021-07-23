package binarysearch;

public class SubsequenceStrings {
    public boolean solve(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        int i = 0;
        int j = 0;
        while (i < s1.length() && j < s2.length()) {
            if (s1.charAt(i) == s2.charAt(j)) i++;
            j++;
        }
        return i == s1.length();
    }
}
