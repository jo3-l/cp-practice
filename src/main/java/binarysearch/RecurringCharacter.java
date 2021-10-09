package binarysearch;

public class RecurringCharacter {
    public int solve(String s) {
        int seen = 0;
        for (int i = 0; i < s.length(); i++) {
            int bit = 1 << (s.charAt(i) - 'a');
            if ((seen & bit) != 0) return i;
            seen |= bit;
        }
        return -1;
    }
}
