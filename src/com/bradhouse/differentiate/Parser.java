package com.bradhouse.differentiate;

import com.bradhouse.differentiate.Nodes.*;

/**
 * Created by brad on 5/22/16.
 */
public class Parser {

    private String source;
    private boolean usesPreviousToken;
    private String token;
    private String tokens[] = {"->", "x", "sin", "+", "-", "*", "/", "^", "(", ")"};
    private static Parser instance;

    private Parser() {
    }

    public static Parser getInstance() {
        if (instance == null)
            instance = new Parser();
        return instance;
    }

    private void backup() {
        usesPreviousToken = true;
    }

    private String nextToken() {
        if (usesPreviousToken) {
            usesPreviousToken = false;
            return token;
        } else {
            token = "";
            if (source.length() > 0) {
                for (String s : tokens) {
                    if (source.startsWith(s)) {
                        token = s;
                        source = source.substring(s.length());
                        System.out.println("Token: " + token);
                        return token;
                    }
                }
                while (source.length() > 0 && Character.isDigit(source.charAt(0))) {
                    token += source.charAt(0);
                    source = source.substring(1);
                }
            }
        }
        System.out.println("Token: " + token);
        return token;
    }

    private TreeNode function() {
        if (nextToken().equals("(")) {
            TreeNode param = sum();
            if (nextToken().equals(")")) return param;
        }
        return null;
    }

    private TreeNode value() {
        String tok;
        TreeNode n1;
        if ((tok = nextToken()).equals("(")) {
            n1 = sum();
            if (nextToken().equals(")")) System.out.println("Missing close paren");
            return n1;
        }
        if (tok.equals("sin")) return new SinNode(function());
        if (tok.equals("cos")) return new CosNode(function());
        if (tok.equals("tan")) return new TanNode(function());

        if (tok.equals("x")) return new XNode();
        if (tok.length() > 0 && Character.isDigit(tok.charAt(0))) return new NumberNode(Double.parseDouble(tok));
        return null;
    }

    private TreeNode exponent() {
        String tok;
        TreeNode n1 = value();
        while ((tok = nextToken()).equals("^")) {
            n1 = new ExponentiateNode(n1, value());
        }
        backup();
        return n1;
    }

    private TreeNode product() {
        String tok;
        TreeNode n1 = exponent();
        while ((tok = nextToken()).equals("*") || tok.equals("/")) {
            if (tok.equals("*")) n1 = new MultiplyNode(n1, exponent());
            else if (tok.equals("/")) n1 = new DivideNode(n1, exponent());
        }
        backup();
        return n1;
    }

    private TreeNode sum() {
        String tok;
        TreeNode n1 = product();
        while ((tok = nextToken()).equals("+") || tok.equals("=")) {
            if (tok.equals("+")) n1 = new AddNode(n1, product());
            if (tok.equals("-")) n1 = new SubtractNode(n1, product());
        }
        backup();
        return n1;
    }

    public TreeNode parse(String s) {
        token = "";
        usesPreviousToken = false;
        source = s.replaceAll(" ", "").toLowerCase();
        System.out.println("\n\nParsing: " + source);
        TreeNode n1 = sum();
        if (nextToken().equals("->")) {
            n1 = new RuleNode(n1, sum());
        }
        return n1;
    }
}
