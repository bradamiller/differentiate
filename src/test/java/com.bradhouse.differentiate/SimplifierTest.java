package com.bradhouse.differentiate;

import com.bradhouse.differentiate.Nodes.NumberNode;
import com.bradhouse.differentiate.Nodes.TreeNode;
import org.junit.Test;
import static org.junit.Assert.*;

public class SimplifierTest {
    Parser p = Parser.Companion.getInstance();
    Simplifier s = new Simplifier();
    Differentiator d = new Differentiator();

    @Test
    public void addZero() {
        TreeNode parsed = p.parse("x+0");
        TreeNode simplified = s.simplified(parsed);
        assertNotNull("x+0 is null", simplified);
        assertTrue("Simplified x+0 wrong", simplified instanceof NumberNode);
    }
}
