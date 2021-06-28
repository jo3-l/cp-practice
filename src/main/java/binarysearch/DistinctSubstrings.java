package binarysearch;

public class DistinctSubstrings {
    public int solve(String s) {
        TrieNode root = new TrieNode();
        int n = 0;
        for (int i = 0; i < s.length(); i++) {
            TrieNode cur = root;
            for (int j = i; j < s.length(); j++) {
                int index = s.charAt(j) - 'a';
                if (cur.child[index] != null) {
                    cur = cur.child[index];
                } else {
                    cur = cur.child[index] = new TrieNode();
                    n++;
                }
            }
        }
        return n;
    }

    public static class TrieNode {
        public TrieNode[] child = new TrieNode[26];
    }
}
