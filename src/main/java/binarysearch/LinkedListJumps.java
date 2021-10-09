package binarysearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LinkedListJumps {
    public LLNode solve(LLNode node) {
        LLNode start = node;
        Map<Integer, List<LLNode>> updates = new HashMap<>();
        int n = 0;
        while (node != null) {
            List<LLNode> vv = updates.get(n);
            if (vv != null) {
                for (LLNode target : vv) target.next = node;
                updates.remove(n);
            }
            if (node.val != 0) {
                List<LLNode> xs = updates.computeIfAbsent(n + node.val, k -> new ArrayList<>());
                xs.add(node);
            }
            n++;
            node = node.next;
        }

        for (List<LLNode> vv : updates.values()) {
            for (LLNode v : vv) v.next = null;
        }
        return start;
    }

    private static class LLNode {
        public int val;
        public LLNode next;
    }
}
