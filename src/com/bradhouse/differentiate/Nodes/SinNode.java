package com.bradhouse.differentiate.Nodes;

/**
 * Created by brad on 5/30/16.
 */
public class SinNode extends TreeNode {
    public String toString() {
        return "sin(" + left + ")";
    }

    public SinNode(TreeNode param) {
        left = param;
    }
}
