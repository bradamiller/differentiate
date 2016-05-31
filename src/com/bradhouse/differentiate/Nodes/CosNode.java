package com.bradhouse.differentiate.Nodes;

/**
 * Created by brad on 5/30/16.
 */
public class CosNode extends TreeNode {
    public String toString() {
        return "cos(" + left + ")";
    }

    public CosNode(TreeNode param) {
        left = param;
    }
}
