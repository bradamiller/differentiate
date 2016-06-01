package com.bradhouse.differentiate.Nodes;

/**
 * Created by brad on 5/22/16.
 */
public abstract class TreeNode {
    TreeNode left;
    TreeNode right;

    public TreeNode getLeft() {
        return left;
    }

    public TreeNode getRight() {
        return right;
    }

    public boolean isLeaf() {
        return false;
    }

    public boolean isSame(TreeNode n) {
        return this.getClass() == n.getClass() && left == n.left && right == n.right;
    }

//    abstract TreeNode diff();
}
