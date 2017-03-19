package com.bradhouse.differentiate.Nodes;

/**
 * Created by brad on 6/7/16.
 */
public class VariableNode extends TreeNode {
    private int index;
    private TreeNode value;

    public VariableNode(int n) {
        index = n;
        value = null;
    }

    public void put(TreeNode t) {
        value = t;
    }

    public TreeNode get() {
        return value;
    }
}
