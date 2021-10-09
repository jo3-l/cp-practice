package binarysearch;

public class LinkedListToInteger {
    public int solve(LLNode node) {
        int n = 0;
        for (LLNode tmp = node; tmp != null; tmp = tmp.next) n++;

        int v = 0;
        while (n-- > 0) {
            if (node.val == 1) v |= 1 << n;
            node = node.next;
        }
        return v;
    }

    public static class LLNode {
        public int val;
        public LLNode next;
    }
}
