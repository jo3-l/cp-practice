package binarysearch;

import java.util.*;

public class RegularExpressionMatching {
    private final char WILDCARD = '.';

    public boolean solve(String pattern, String s) {
        Node root = new Node();
        List<Node> cur = new ArrayList<>();
        cur.add(root);
        int i = 0;
        while (i < pattern.length()) {
            char c = pattern.charAt(i);
            if (i != pattern.length() - 1 && pattern.charAt(i + 1) == '*') {
                i += 2;

                int mark = cur.size();
                for (int j = 0; j < mark; j++) {
                    Node v = cur.get(j);
                    cur.add(v);
                    v.child.putIfAbsent(c, new Node());
                    v = v.child.get(c);
                    v.isRepetition = true;
                    v.val = c;
                    cur.set(j, v);
                }
            } else {
                i++;

                int mark = cur.size();
                for (int j = 0; j < mark; j++) {
                    Node v = cur.get(j);
                    v.child.putIfAbsent(c, new Node());
                    v = v.child.get(c);
                    v.val = c;
                    cur.set(j ,v);
                }
            }
        }

        for (Node v : cur) v.isLeaf = true;

        Queue<Node> inProgress = new LinkedList<>();
        inProgress.add(root);
        for (int j = 0; j < s.length(); j++) {
            char c = s.charAt(j);

            int sz = inProgress.size();
            while (sz-- > 0) {
                Node v = inProgress.poll();
                Node child = v.child.get(c);
                if (child != null) inProgress.add(child);

                child = v.child.get(WILDCARD);
                if (child != null) inProgress.add(child);

                if (v.isRepetition && (v.val == WILDCARD || v.val == c)) inProgress.add(v);
            }

            if (inProgress.isEmpty()) return false;
        }

        return inProgress.stream().anyMatch(v -> v.isLeaf);
    }

    private static class Node {
        public char val;
        public boolean isLeaf;
        public boolean isRepetition;
        public Map<Character, Node> child = new HashMap<>();
    }
}
