package binarysearch;

import java.util.ArrayList;
import java.util.List;

public class PalindromeLinkedList {
    public boolean solve(LLNode node) {
        List<Integer> xs = new ArrayList<>();
        while (node != null) {
            xs.add(node.val);
            node = node.next;
        }

        for (int i = 0; i < xs.size() >> 1; i++) {
            if (!xs.get(i).equals(xs.get(xs.size() - i - 1))) return false;
        }
        return true;
    }

    public static class LLNode {
        public int val;
        public LLNode next;
    }
}
