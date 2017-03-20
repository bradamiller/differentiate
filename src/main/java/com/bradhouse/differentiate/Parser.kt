package com.bradhouse.differentiate

import com.bradhouse.differentiate.Nodes.*

class Parser private constructor() {

    private var source: String? = null
    private var usesPreviousToken: Boolean = false
    private var token: String = ""
    private val tokens = arrayOf("->", "x", "sin", "+", "-", "*", "/", "^", "(", ")", "$")

    private fun backup() {
        usesPreviousToken = true
    }

    private fun nextToken(): String {
        if (usesPreviousToken) {
            usesPreviousToken = false
            return token!!
        } else {
            token = ""
            if (source!!.length > 0) {
                for (s in tokens) {
                    if (source!!.startsWith(s)) {
                        token = s
                        source = source!!.substring(s.length)
                        //                        System.out.println("Token: " + token);
                        return token!!
                    }
                }
                while (source!!.length > 0 && Character.isDigit(source!![0])) {
                    token += source!![0]
                    source = source!!.substring(1)
                }
            }
        }
        //        System.out.println("Token: " + token);
        return token!!
    }

    private fun function(): TreeNode? {
        if (nextToken() == "(") {
            val param = sum()
            if (nextToken() == ")") return param
        }
        return null
    }

    private fun value(): TreeNode {
        val n1: TreeNode
        nextToken()
        if (token == "(") {
            n1 = sum()
            if (nextToken() != ")") println("Missing close paren")
            return n1
        }
        else if (token == "sin") return SinNode(function())
        else if (token == "cos") return CosNode(function())
        else if (token == "tan") return TanNode(function())
        else if (token == "x") return XNode()
        else if (token == "$") {
            nextToken()
            if (token.length > 0 && Character.isDigit(token[0])) {
                val index = Integer.parseInt(token)
                if (index >= 0 && index <= 9) {
                    println("VariableNode: " + index)
                    return VariableNode(index)
                } else {
                    println("bad placeholder: " + token);
                    return VariableNode(0);
                }
            }
        }
        else if (token.length > 0 && Character.isDigit(token[0]))
            return NumberNode(java.lang.Double.parseDouble(token))
        return ErrorNode();
    }

    private fun exponent(): TreeNode {
        var n1: TreeNode = value()
        while (nextToken() == "^") {
            n1 = ExponentiateNode(n1, value())
        }
        backup()
        return n1
    }

    private fun product(): TreeNode {
        var tok: String
        var n1 = exponent()
        while (nextToken() == "*" || token == "/") {
            if (token == "*")
                n1 = MultiplyNode(n1, exponent())
            else if (token == "/") n1 = DivideNode(n1, exponent())
        }
        backup()
        return n1
    }

    private fun sum(): TreeNode {
        var tok: String
        var n1 = product()
        while (nextToken() == "+" || token == "=") {
            if (token == "+") n1 = AddNode(n1, product())
            if (token == "-") n1 = SubtractNode(n1, product())
        }
        backup()
        return n1
    }

    fun parse(s: String): TreeNode {
        token = ""
        usesPreviousToken = false
        source = s.replace(" ".toRegex(), "").toLowerCase()
        println("\n\nParsing: " + source!!)
        var n1 = sum()
        if (nextToken() == "->") {
            n1 = RuleNode(n1, sum())
        }
        return n1
    }

    companion object {
        val instance: Parser = Parser()
    }
}
