package binarysearch;

public class LinkedListUnion {
    public LLNode solve(LLNode ll0, LLNode ll1) {
        if (ll0 == ll1) return null;
        LLNode head = new LLNode();
        LLNode cur = head;
        LLNode prevV = null;
        while (ll0 != null || ll1 != null) {
            prevV = cur;

            int v0 = ll0 == null ? Integer.MAX_VALUE : ll0.val;
            int v1 = ll1 == null ? Integer.MAX_VALUE : ll1.val;
            if (v0 <= v1) {
                cur.val = v0;
                cur = cur.next = new LLNode();
                if (ll0 != null) ll0 = ll0.next;
                if (v0 == v1 && ll1 != null) ll1 = ll1.next;
            } else {
                cur.val = v1;
                cur = cur.next = new LLNode();
                ll1 = ll1.next;
            }
        }
        prevV.next = null;
        return head;
    }

    public static class LLNode {
        public int val;
        public LLNode next;
    }
}
