package binarysearch;

public class LinkedListToZigZagTreePath {
    public Tree solve(LLNode node) {
        if (node == null) return null;
        Tree headTreeNode = new Tree();

        headTreeNode.val = node.val;

        Tree parentTreeNode = headTreeNode;
        for (LLNode curNode = node.next; curNode != null; curNode = curNode.next) {
            Tree newTreeNode = new Tree();
            newTreeNode.val = curNode.val;
            if (curNode.val < parentTreeNode.val) {
                parentTreeNode.left = newTreeNode;
            } else {
                parentTreeNode.right = newTreeNode;
            }

            parentTreeNode = newTreeNode;
        }

        return headTreeNode;
    }

    public class Tree {
        int val;
        Tree left;
        Tree right;
    }

    public class LLNode {
        int val;
        LLNode next;
    }
}
