package binarysearch;

import java.util.ArrayList;
import java.util.List;

public class Embolden {
    public String solve(String text, String[] patterns) {
        TrieNode root = buildTrie(patterns);
        List<int[]> matches = new ArrayList<>();
        for (int i = 0; i < text.length(); i++) {
            int endIdx = -1;
            TrieNode cur = root;
            for (int j = i; j < text.length(); j++) {
                int offset = text.charAt(j) - 'a';
                if (cur.children[offset] == null) break;
                cur = cur.children[offset];
                if (cur.isLeaf) endIdx = j;
            }

            if (endIdx != -1) matches.add(new int[]{i, endIdx});
        }

        StringBuilder res = new StringBuilder();
        int lastPos = 0;
        for (int[] loc : matches) {
            int startIdx = loc[0];
            int endIdx = loc[1];
            if (lastPos == 0 || lastPos < startIdx) {
                res.append(text, lastPos, startIdx);
                res.append("<b>");
                res.append(text, startIdx, endIdx + 1);
                res.append("</b>");

                lastPos = endIdx + 1;
                continue;
            }

            res.delete(res.length() - 4 /* "</b>".length */, res.length());
            res.append(text, lastPos, endIdx + 1);
            res.append("</b>");
            lastPos = endIdx + 1;
        }

        res.append(text, lastPos, text.length());
        return res.toString();
    }

    private TrieNode buildTrie(String[] patterns) {
        TrieNode root = new TrieNode();
        for (String pattern : patterns) {
            TrieNode cur = root;
            for (int i = 0; i < pattern.length(); i++) {
                int offset = pattern.charAt(i) - 'a';
                if (cur.children[offset] != null) cur = cur.children[offset];
                else cur = cur.children[offset] = new TrieNode();
            }
            cur.isLeaf = true;
        }
        return root;
    }

    private static class TrieNode {
        public TrieNode[] children = new TrieNode[26];
        public boolean isLeaf;
    }
}
