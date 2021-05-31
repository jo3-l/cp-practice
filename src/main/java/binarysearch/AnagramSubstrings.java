package binarysearch;

public class AnagramSubstrings {
    public int solve(String small, String big) {
        if (big.length() < small.length()) return 0;
        int d = 0;
        int[] smallv = new int[26];
        int[] mp = new int[26];
        // populate initial values
        for (int i = 0; i < small.length(); i++) {
            mp[big.charAt(i) - 'a']++;
            smallv[small.charAt(i) - 'a']++;
        }

        int ret = 0;
        if (areIntArraysEq(mp, smallv)) ret++;

        // advance window
        for (int i = small.length(); i < big.length(); i++) {
            mp[big.charAt(i) - 'a']++;
            mp[big.charAt(d++) - 'a']--;
            if (areIntArraysEq(mp, smallv)) ret++;
        }

        return ret;
    }

    private boolean areIntArraysEq(int[] arr0, int[] arr1) {
        for (int i = 0; i < arr0.length; i++) {
            if (arr0[i] != arr1[i]) return false;
        }
        return true;
    }
}
