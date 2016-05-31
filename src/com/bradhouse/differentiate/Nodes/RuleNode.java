package com.bradhouse.differentiate.Nodes;

/**
 * Created by brad on 5/31/16.
 */
public class RuleNode extends TreeNode {

    public RuleNode(TreeNode pattern, TreeNode replacement) {
        left = pattern;
        right = replacement;
    }

    public String toString() {
        return left + "->" + right;
    }
}
