package binarysearch;

public class ReverseWords {
    public String solve(String sentence) {
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length >> 1; i++) {
            String tmp = words[i];
            words[i] = words[words.length - i - 1];
            words[words.length - i - 1] = tmp;
        }

        return String.join(" ", words);
    }
}
