package com.bradhouse.differentiate;

import com.bradhouse.differentiate.Nodes.TreeNode;
import com.bradhouse.differentiate.Parser.Parser;

public class Main {

    public static void main(String[] args) {
        String tests[] = {"2*x", "2*x",
                "x*2",
                "sin(x)",
                "2+x",
                "2*x",
                "2-x",
                "2/x",
                "x-2",
                "x/2"};
        Parser p = new Parser();
        Simplifier s = new Simplifier();
        Differentiator d = new Differentiator();

        for (String test: tests) {
            TreeNode parsed = p.parse(test);
            System.out.println("parsed: " + parsed);
            TreeNode simplified = s.simplified(parsed);
            System.out.println("simplified: " + simplified);
            TreeNode differentiated = d.differentiate(simplified);
            System.out.println("differentiated: " + differentiated);
            TreeNode reSimplified = s.simplified(differentiated);
            System.out.println("reSimplified: " + reSimplified);
        }
    }
}
