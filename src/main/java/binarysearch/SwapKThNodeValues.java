package binarysearch;

public class SwapKThNodeValues {
    public LLNode solve(LLNode node, int k) {
        LLNode kthFromStart = null;
        int len = 0;
        LLNode cur = node;
        while (cur != null) {
            if (len++ == k) kthFromStart = cur;
            cur = cur.next;
        }

        LLNode n = node;
        for (int i = 0; i < len - k - 1; i++) {
            n = n.next;
        }
        int tmp = n.val;
        n.val = kthFromStart.val;
        kthFromStart.val = tmp;
        return node;
    }

    public static class LLNode {
        public int val;
        public LLNode next;
    }
}
