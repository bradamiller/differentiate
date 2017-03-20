package com.bradhouse.differentiate;

import com.bradhouse.differentiate.Nodes.SinNode;
import com.bradhouse.differentiate.Nodes.TreeNode;
import com.bradhouse.differentiate.Nodes.XNode;
import org.junit.Test;
import static org.junit.Assert.*;

public class ParseTest {
    String tests[] = {
            "x+0", "0+x",
            "2*x", "2*x",
            "x*2",
            "sin(x)",
            "2+x",
            "2*x",
            "2-x",
            "2/x",
            "x-2",
            "x/2"};

    Parser p = Parser.Companion.getInstance();
    Simplifier s = new Simplifier();
    Differentiator d = new Differentiator();

    @Test
    public void testSin() {
        TreeNode parsed = p.parse("sin(x)");
        assertNotNull(parsed);
        assertNull("Right parameter of sin not null", parsed.getRight());
        assertEquals("Did not generate a sin node", SinNode.class, parsed.getClass());
        assertEquals("sin(x) parameter not x", XNode.class, parsed.getLeft().getClass());
    }

    @Test
    public void testStuff() {
        for (String test : tests) {
            System.out.println("\n\n");
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
