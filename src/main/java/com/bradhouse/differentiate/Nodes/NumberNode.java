package com.bradhouse.differentiate.Nodes;

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
