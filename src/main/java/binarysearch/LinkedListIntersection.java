package binarysearch;

public class LinkedListIntersection {
    public LLNode solve(LLNode l0, LLNode l1) {
        LLNode cur = new LLNode(0, null);
        LLNode dummy = cur;
        while (l0 != null && l1 != null) {
            int v0 = l0.val;
            int v1 = l1.val;
            if (v0 == v1) {
                cur = cur.next = new LLNode(v0, null);
                while (l0 != null && l0.val == v0) l0 = l0.next;
                while (l1 != null && l1.val == v0) l1 = l1.next;
            } else if (v0 < v1) {
                l0 = l0.next;
            } else {
                l1 = l1.next;
            }
        }
        return dummy.next;
    }

    private static class LLNode {
        public int val;
        public LLNode next;

        public LLNode(int val, LLNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
