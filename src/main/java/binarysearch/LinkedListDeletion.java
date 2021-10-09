package binarysearch;

public class LinkedListDeletion {
    public LLNode solve(LLNode node, int target) {
        while (node != null && node.val == target) node = node.next;
        if (node == null) return node;
        LLNode prev = node;
        LLNode cur = node.next;
        while (cur != null) {
            if (cur.val == target) {
                prev.next = cur = cur.next;
            } else {
                prev = cur;
                cur = cur.next;
            }
        }

        return node;
    }

    public static class LLNode {
        public int val;
        public LLNode next;
    }
}
