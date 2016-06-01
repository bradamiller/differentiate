package com.bradhouse.differentiate.Nodes;

/**
 * Created by brad on 5/28/16.
 */
public class NumberNode extends TreeNode {
    double value = 0;

    @Override
    public String toString() {
        return "" + value;
    }

    public NumberNode(double v) {
        value = v;
    }

    public boolean isLeaf() {
        return true;
    }
}
