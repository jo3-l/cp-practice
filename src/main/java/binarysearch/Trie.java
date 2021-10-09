package binarysearch;

public class Trie {
    private TrieNode root = new TrieNode();

    public void add(String s) {
        TrieNode cur = root;
        for (int i = 0; i < s.length(); i++) {
            int o = s.charAt(i) - 'a';
            TrieNode v = cur.children[o];
            if (v == null) {
                cur = cur.children[o] = new TrieNode();
            } else {
                cur = v;
            }
        }

        cur.isLeaf = true;
    }

    public boolean exists(String word) {
        TrieNode f = traverse(word);
        return f != null && f.isLeaf;
    }

    public boolean startswith(String p) {
        return traverse(p) != null;
    }

    private TrieNode traverse(String p) {
        TrieNode cur = root;
        for (int i = 0; i < p.length(); i++) {
            int o = p.charAt(i) - 'a';
            TrieNode v = cur.children[o];
            if (v == null) return null;
            cur = v;
        }

        return cur;
    }

    private static class TrieNode {
        public boolean isLeaf = false;
        public TrieNode[] children = new TrieNode[26];
    }
}
