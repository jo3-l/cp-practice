package binarysearch;

public class BinaryTreeToLinkedList {
    private LLNode original = new LLNode();
    private LLNode curNode = original;

    public LLNode solve(Tree root) {
        if (root == null) return null;
        if (root.left != null) solve(root.left);
        LLNode newNode = new LLNode();
        newNode.val = root.val;
        curNode.next = newNode;
        curNode = newNode;
        if (root.right != null) solve(root.right);
        return original.next;
    }

    public static class Tree {
        public int val;
        public Tree left;
        public Tree right;
    }

    public class LLNode {
        public int val;
        public LLNode next;
    }
}
