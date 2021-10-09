package binarysearch;

public class BreakStringIntoWords {
    private int[] seen; // value 0 -> unknown, 1 -> true, 2 -> false

    public boolean solve(String[] words, String s) {
        seen = new int[s.length()];
        TrieNode root = buildTrie(words);
        return match(s, 0, root) == 1;
    }

    private int match(String s, int idx, TrieNode root) {
        if (idx == s.length()) return 1;
        if (seen[idx] != 0) return seen[idx];
        TrieNode cur = root;
        for (int i = idx; i < s.length(); i++) {
            int offset = s.charAt(i) - 'a';
            if (cur.child[offset] == null) return seen[idx] = 2;
            cur = cur.child[offset];
            if (cur.isLeaf && match(s, i + 1, root) == 1) return seen[idx] = 1;
        }
        return seen[idx] = 2;
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode cur = root;
            for (int i = 0; i < word.length(); i++) {
                int offset = word.charAt(i) - 'a';
                if (cur.child[offset] != null) {
                    cur = cur.child[offset];
                } else {
                    cur = cur.child[offset] = new TrieNode();
                }
            }
            cur.isLeaf = true;
        }

        return root;
    }

    public static class TrieNode {
        public boolean isLeaf;
        public TrieNode[] child = new TrieNode[26];
    }
}
