package binarysearch;

public class WordFormation {
    public int solve(String[] words, String letters) {
        int max = 0;

        int[] lFreqs = freqs(letters);
        for (String word : words) {
            int[] wFreqs = freqs(word);
            int i;
            for (i = 0; i < lFreqs.length; i++) {
                if (wFreqs[i] > lFreqs[i]) break;
            }

            if (i == lFreqs.length) max = Math.max(word.length(), max);
        }

        return max;
    }

    private int[] freqs(String word) {
        int[] freqs = new int[26];
        for (int i = 0; i < word.length(); i++) {
            freqs[word.charAt(i) - 'a']++;
        }

        return freqs;
    }
}
