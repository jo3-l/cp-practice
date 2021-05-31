package binarysearch;

import java.util.ArrayList;
import java.util.List;

public class TreeTraversal {
    public int solve(Tree root, String[] moves) {
        List<Tree> stack = new ArrayList<>();
        stack.add(root);
        for (String move : moves) {
            switch (move) {
                case "RIGHT": {
                    Tree last = stack.get(stack.size() - 1);
                    stack.add(last.right);
                    break;
                }
                case "LEFT": {
                    Tree last = stack.get(stack.size() - 1);
                    stack.add(last.left);
                    break;
                }
                case "UP":
                    stack.remove(stack.size() - 1);
                    break;
            }
        }

        return stack.get(stack.size() - 1).val;
    }

    public static class Tree {
        public int val;
        public Tree left;
        public Tree right;
    }
}
