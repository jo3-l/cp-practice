package binarysearch;

public class KThLastNode {
    public int solve(LLNode node, int k) {
        LLNode fast = node;
        for (int i = 0; i < k + 1; i++) fast = fast.next;

        LLNode cur = node;
        while (fast != null) {
            fast = fast.next;
            cur = cur.next;
        }

        return cur.val;
    }

    public static class LLNode {
        public int val;
        public LLNode next;
    }
}
