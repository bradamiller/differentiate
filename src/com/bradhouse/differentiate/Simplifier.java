package com.bradhouse.differentiate;

import com.bradhouse.differentiate.Nodes.TreeNode;
import com.bradhouse.differentiate.Parser.Parser;

import java.util.ArrayList;

/**
 * Created by brad on 5/22/16.
 */
public class Simplifier {

    private String simplificationsSource[] = {
            "x+0->x", "0+x->x"
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

    public TreeNode simplified(TreeNode parsed) {
        return parsed;
    }
}
