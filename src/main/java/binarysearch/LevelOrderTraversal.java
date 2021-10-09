package binarysearch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
    public int[] solve(Tree root) {
        if (root == null) return new int[]{};

        List<Integer> xs = new ArrayList<>();
        Queue<Tree> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Tree node = queue.poll();
            xs.add(node.val);
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }

        int[] res = new int[xs.size()];
        for (int i = 0; i < xs.size(); i++) res[i] = xs.get(i);
        return res;
    }

    public static class Tree {
        public int val;
        public Tree left;
        public Tree right;
    }
}
