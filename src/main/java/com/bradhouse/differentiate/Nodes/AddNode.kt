package com.bradhouse.differentiate.Nodes

class AddNode(l: TreeNode, r: TreeNode) : TreeNode() {

    override fun toString(): String {
        return left.toString() + " + " + right
    }

    init {
        left = l
        right = r
    }
}
