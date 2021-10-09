package binarysearch;

public class MaxCharacterDistinctWords {
    public int solve(String[] words) {
        int[] letters = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (int j = 0; j < word.length(); j++) letters[i] |= 1 << (word.charAt(j) - 'a');
        }

        int best = 0;
        for (int i = 0; i < words.length; i++) {
            for  (int j = i + 1; j < words.length; j++) {
                if ((letters[i] & letters[j]) == 0) best = Math.max(best, words[i].length() + words[j].length());
            }
        }
        return best;
    }
}
