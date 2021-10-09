package binarysearch;

import java.util.ArrayDeque;
import java.util.Queue;

public class SearchEngine {
    private TrieNode root = new TrieNode();

    public void add(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            int o = word.charAt(i) - 'a';
            if (cur.child[o] != null) {
                cur = cur.child[o];
            } else {
                cur = cur.child[o] = new TrieNode();
            }
        }
        cur.isLeaf = true;
    }

    public boolean exists(String word) {
        if (!word.contains(".")) return existsFast(word);

        Queue<TrieNode> checkQ = new ArrayDeque<>();
        checkQ.add(root);

        int idx = 0;
        while (!checkQ.isEmpty() && idx < word.length()) {
            char c = word.charAt(idx);
            boolean isLast = idx == word.length() - 1;

            int sz = checkQ.size();
            while (sz-- > 0) {
                TrieNode cur = checkQ.poll();
                if (c == '.') {
                    boolean anyLeaf = false;
                    for (TrieNode n : cur.child) {
                        if (n != null) {
                            checkQ.add(n);
                            anyLeaf = anyLeaf || n.isLeaf;
                        }
                    }
                    if (isLast && anyLeaf) return true;
                } else {
                    TrieNode child = cur.child[c - 'a'];
                    if (child != null) {
                        if (isLast && child.isLeaf) return true;
                        checkQ.add(child);
                    }
                }
            }
            idx++;
        }

        return false;
    }

    private boolean existsFast(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            int o = word.charAt(i) - 'a';
            cur = cur.child[o];
            if (cur == null) return false;
        }
        return cur.isLeaf;
    }

    private static class TrieNode {
        public boolean isLeaf;
        public TrieNode[] child = new TrieNode[26];
    }
}
