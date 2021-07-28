package binarysearch;

public class ReverseAnInnerLinkedList {
    public LLNode solve(LLNode node, int i, int j) {
        LLNode begin = node;
        LLNode beforeBegin = null;
        for (int z = 0; z < i; z++) {
            beforeBegin = beforeBegin == null ? node : beforeBegin.next;
            begin = begin.next;
        }
        LLNode end = begin;
        for (int z = i; z < j; z++) end = end.next;
        LLNode afterEnd = end.next;

        end.next = null;
        end = reverse(begin);
        if (beforeBegin != null) beforeBegin.next = end;
        else node = end;
        begin.next = afterEnd;
        return node;
    }

    private LLNode reverse(LLNode node) {
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

    private static class LLNode {
        public int val;
        public LLNode next;
    }
}
