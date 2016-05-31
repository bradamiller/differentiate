package com.bradhouse.differentiate.Nodes;

/**
 * Created by brad on 5/22/16.
 */
public class SubtractNode extends TreeNode {
    @Override
    public String toString() {
        return left + "-" + right;
    }

    public SubtractNode(TreeNode l, TreeNode r) {
        left = l;
        right = r;
    }
}
