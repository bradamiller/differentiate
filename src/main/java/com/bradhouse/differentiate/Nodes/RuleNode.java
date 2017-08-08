package com.bradhouse.differentiate.Nodes;

/**
 * Created by brad on 5/31/16.
 */
public class RuleNode extends TreeNode {

    public RuleNode(TreeNode pattern, TreeNode replacement) {
        setLeft(pattern);
        setRight(replacement);
    }

    public String toString() {
        return getLeft() + " -> " + getRight();
    }
}
