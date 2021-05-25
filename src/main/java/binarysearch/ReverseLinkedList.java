package binarysearch;

public class ReverseLinkedList {
    public LLNode solve(LLNode node) {
        if (node == null) return null;

        LLNode original = node;

        LLNode prev = node;
        node = node.next;
        while (node != null) {
            LLNode nextNode = node.next;
            node.next = prev;
            prev = node;
            node = nextNode;
        }

        original.next = null;
        return prev;
    }

    public static class LLNode {
        int val;
        LLNode next;
    }
}
