package binarysearch;

public class WordFormationSequel {
    private final int WILDCARD_IDX = 26;

    public int solve(String[] words, String letters) {
        int max = 0;

        int[] lFreqs = freqs(letters);
        for (String word : words) {
            int original = lFreqs[WILDCARD_IDX];

            int[] wFreqs = freqs(word);
            int i;
            for (i = 0; i < lFreqs.length; i++) {
                int delta = wFreqs[i] - lFreqs[i];
                if (delta > 0) {
                    if (delta <= lFreqs[WILDCARD_IDX]) lFreqs[WILDCARD_IDX] -= delta;
                    else break;
                }
            }

            if (i == lFreqs.length) max = Math.max(word.length(), max);
            lFreqs[WILDCARD_IDX] = original;
        }

        return max;
    }

    private int[] freqs(String word) {
        int[] freqs = new int[27];
        for (int i = 0; i < word.length(); i++) {
            int k = word.charAt(i) - 'a';
            if (k < 0) k = WILDCARD_IDX;
            freqs[k]++;
        }

        return freqs;
    }
}
