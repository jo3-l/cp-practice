package binarysearch;

public class WordConcatenation {
    public int solve(String[] words) {
        TrieNode root = buildTrie(words);
        int n = 0;
        for (int id = 0; id < words.length; id++) {
            String word = words[id];
            if (match(root, word, 0, id)) n++;
        }
        return n;
    }

    private boolean match(TrieNode root, String word, int wordIdx, int wordID) {
        if (wordIdx == word.length()) return true;
        TrieNode cur = root;
        for (int i = wordIdx; i < word.length(); i++) {
            int offset = word.charAt(i) - 'a';
            if (cur.child[offset] == null) return false;
            cur = cur.child[offset];
            if (i == word.length() - 1) return cur.wordID != wordID && cur.wordID != -1;
            if (cur.wordID != -1 && match(root, word, i + 1, wordID)) return true;
        }
        return false;
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            TrieNode cur = root;
            for (int j = 0; j < word.length(); j++) {
                int offset = word.charAt(j) - 'a';
                if (cur.child[offset] != null) cur = cur.child[offset];
                else cur = cur.child[offset] = new TrieNode();
            }
            cur.wordID = i;
        }
        return root;
    }

    public static class TrieNode {
        public int wordID = -1;
        public TrieNode[] child = new TrieNode[26];
    }
}
