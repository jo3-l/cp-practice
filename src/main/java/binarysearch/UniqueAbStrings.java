package binarysearch;

public class UniqueAbStrings {
    public int solve(String s) {
        int numA = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') numA++;
        }
        return 1 << numA; // powerset
    }
}
