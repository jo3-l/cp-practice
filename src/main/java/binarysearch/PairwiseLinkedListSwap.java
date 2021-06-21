package binarysearch;

public class PairwiseLinkedListSwap {
    public LLNode solve(LLNode node) {
        if (node == null) return null;
        LLNode cur = node;
        while (cur != null && cur.next != null) {
            int tmp = cur.val;
            cur.val = cur.next.val;
            cur.next.val = tmp;
            cur = cur.next.next;
        }
        return node;
    }

    private static class LLNode {
        public int val;
        public LLNode next;
    }
}
