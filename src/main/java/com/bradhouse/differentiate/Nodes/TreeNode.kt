package com.bradhouse.differentiate.Nodes

abstract class TreeNode {
    var left: TreeNode? = null
    var right: TreeNode? = null

    open val isLeaf = false

    fun isSame(n: TreeNode): Boolean {
        return this.javaClass == n.javaClass && left == n.left && right == n.right
    }

    override fun toString(): String {
        return ""
    }

}
