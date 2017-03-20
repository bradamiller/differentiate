package com.bradhouse.differentiate.Nodes

class VariableNode(private val index: Int) : TreeNode() {
    private var value: TreeNode? = null

    override fun toString(): String {
        return "$" + index
    }

    fun put(t: TreeNode) {
        value = t
    }

    fun get(): TreeNode? {
        return value
    }
}
