package binarysearch;

public class AddLinkedList {
    public LLNode solve(LLNode l0, LLNode l1) {
        LLNode head = new LLNode();
        LLNode cur = head;
        int carry = 0;
        while (l0 != null || l1 != null) {
            int v0 = l0 == null ? 0 : l0.val;
            int v1 = l1 == null ? 0 : l1.val;
            int vv = v0 + v1 + carry;
            if (vv >= 10) {
                carry = 1;
                vv -= 10;
            } else {
                carry = 0;
            }

            cur.val = vv;
            if (l0 != null) l0 = l0.next;
            if (l1 != null) l1 = l1.next;
            if (l0 != null || l1 != null) cur = cur.next = new LLNode();
        }
        if (carry != 0) {
            cur.next = new LLNode();
            cur.next.val = 1;
        }
        return head;
    }

    public static class LLNode {
        public int val;
        public LLNode next;
    }
}
