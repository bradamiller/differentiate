package com.bradhouse.differentiate;

import com.bradhouse.differentiate.Nodes.RuleNode;
import com.bradhouse.differentiate.Nodes.TreeNode;
import com.bradhouse.differentiate.Nodes.VariableNode;

import java.util.ArrayList;

/**
 * Created by brad on 5/22/16.
 */
public class Simplifier {

    private String simplificationsSource[] = {
            "$1+0->$1"
    };

    private ArrayList<TreeNode> simplifications;

    public Simplifier() {
        Parser parser = Parser.getInstance();
        simplifications = new ArrayList<>();
        for (String s : simplificationsSource) {
            TreeNode simp = parser.parse(s);
            simplifications.add(simp);
            System.out.println("Simplification rule: " + simp);
        }
    }

    private boolean matches(TreeNode pattern, TreeNode source) {
        if (pattern instanceof VariableNode) {
            ((VariableNode) pattern).put(source);
            return true;
        }
        if (pattern.getClass() == source.getClass()) {
            boolean match = true;
            if (pattern.isLeaf()) return pattern.isSame(source);
            if (pattern.getLeft() != null) match = matches(pattern.getLeft(), source.getLeft());
            if (pattern.getRight() != null) match &= matches(pattern.getRight(), source.getRight());
            return match;
        }
        return false;
    }

    public TreeNode simplify(TreeNode node) {
        for (TreeNode rule: simplifications) {
            assert (rule instanceof RuleNode);
            TreeNode pattern = rule.getLeft();
            if (matches(pattern, node)) {
                return rule.getRight();
            }
        }
        return node;
    }

    public TreeNode simplified(TreeNode parsed) {
        return simplify(parsed);
    }
}
