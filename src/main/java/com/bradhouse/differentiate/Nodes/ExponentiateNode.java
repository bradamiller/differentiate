package com.bradhouse.differentiate.Nodes;

/**
 * Created by brad on 5/22/16.
 */
public class ExponentiateNode extends TreeNode {
    @Override
    public String toString() {
        return getLeft() + "^" + getRight();
    }

    public ExponentiateNode(TreeNode l, TreeNode r) {
        setLeft(l);
        setRight(r);
    }
}
