package binarysearch;

public class SentenceReversal {
    public String[] solve(String[] sentence) {
        int i = 0;
        while (i < sentence.length) {
            int j = i;
            while (j < sentence.length && sentence[j].charAt(0) != ' ') j++;
            int next = j-- + 1;
            while (i < j) {
                String tmp = sentence[i];
                sentence[i++] = sentence[j];
                sentence[j--] = tmp;
            }
            i = next;
        }

        for (int z = 0; z < sentence.length >> 1; z++) {
            String tmp = sentence[z];
            sentence[z] = sentence[sentence.length - z - 1];
            sentence[sentence.length - z - 1] = tmp;
        }
        return sentence;
    }
}
