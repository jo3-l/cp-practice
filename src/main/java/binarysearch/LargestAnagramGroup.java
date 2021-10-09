package binarysearch;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class LargestAnagramGroup {
    public int solve(String[] words) {
        Map<AnagramInfo, Integer> xs = new HashMap<>();
        for (String word : words) {
            xs.merge(f(word), 1, Integer::sum);
        }
        return xs.values().stream().max(Comparator.naturalOrder()).get();
    }

    private AnagramInfo f(String word) {
        int[] fs = new int[26];
        for (int i = 0; i < word.length(); i++) fs[word.charAt(i) - 'a']++;
        return new AnagramInfo(fs);
    }

    private static class AnagramInfo {
        public int[] freq;

        public AnagramInfo(int[] freq) {
            this.freq = freq;
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(freq);
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof AnagramInfo)) return false;
            AnagramInfo a = (AnagramInfo) obj;
            return Arrays.equals(a.freq, freq);
        }
    }
}
