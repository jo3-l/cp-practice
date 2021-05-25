package binarysearch;

import java.util.LinkedList;
import java.util.Queue;

public class LeavesInSameLevel {
    public boolean solve(Tree root) {
        Queue<Tree> Q = new LinkedList<>();
        Q.add(root);

        int leafDepth = -1;
        int depth = 1;
        while (!Q.isEmpty()) {
            int breadth = Q.size();
            while (breadth-- > 0) {
                Tree node = Q.poll();
                if (node.left == null && node.right == null) {
                    if (leafDepth == -1) {
                        leafDepth = depth;
                    } else if (leafDepth != depth) {
                        return false;
                    }
                }

                if (node.left != null) Q.add(node.left);
                if (node.right != null) Q.add(node.right);
            }

            depth++;
        }

        return true;
    }

    public static class Tree {
        public int val;
        public Tree left;
        public Tree right;
    }
}
