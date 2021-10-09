package binarysearch;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicatesInLinkedList {
    public LLNode solve(LLNode node) {
        Set<Integer> seen = new HashSet<>();
        LLNode prev = new LLNode(0, node);
        LLNode head = prev;
        while (node != null) {
            if (!seen.add(node.val)) prev.next = node.next;
            else prev = node;
            node = node.next;
        }
        return head.next;
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
