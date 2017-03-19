package com.bradhouse.differentiate.Nodes;

/**
 * Created by brad on 5/30/16.
 */
public class CosNode extends TreeNode {
    public String toString() {
        return "cos(" + getLeft() + ")";
    }

    public CosNode(TreeNode param) {
        setLeft(param);
    }
}
