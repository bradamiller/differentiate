package com.bradhouse.differentiate.Nodes;

/**
 * Created by brad on 5/30/16.
 */
public class TanNode extends TreeNode {
    public String toString() {
        return "tan(" + left + ")";
    }

    public TanNode(TreeNode param) {
        left = param;
    }
}
