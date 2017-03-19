package com.bradhouse.differentiate.Nodes;

/**
 * Created by brad on 5/30/16.
 */
public class TanNode extends TreeNode {
    public String toString() {
        return "tan(" + getLeft() + ")";
    }

    public TanNode(TreeNode param) {
        setLeft(param);
    }
}
