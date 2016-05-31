package com.bradhouse.differentiate.Nodes;

/**
 * Created by brad on 5/22/16.
 */
public class ExponentiateNode extends TreeNode {
    @Override
    public String toString() {
        return left + "^" + right;
    }

    public ExponentiateNode(TreeNode l, TreeNode r) {
        left = l;
        right = r;
    }
}
