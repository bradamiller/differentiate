package com.bradhouse.differentiate.Nodes;

/**
 * Created by brad on 5/22/16.
 */
public class AddNode extends TreeNode {

    @Override
    public String toString() {
        return left + " + " + right;
    }

    public AddNode(TreeNode l, TreeNode r) {
        left = l;
        right = r;
    }
}
