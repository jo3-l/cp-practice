package binarysearch;

public class CountSubstringsWithAllOnes {
    public int solve(String s) {
        if (s.isEmpty()) return 0;

        int total = 0;
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) != '1') {
                i++;
                continue;
            }

            int j = i + 1;
            while (j < s.length() && s.charAt(j) == '1') j++;
            total += countSubstrings(i, j - 1);
            total %= 1_000_000_007;
            i = j;
        }
        return total;
    }

    private int countSubstrings(int begin, int end) {
        int len = end - begin + 1;
        return (((len * (len - 1)) / 2) + len) % 1_000_000_007;
    }
}
