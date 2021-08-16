package ru.orangepigment.trees

import ru.orangepigment.data.Node

import scala.collection.mutable

/**
 * [[https://leetcode.com/problems/n-ary-tree-preorder-traversal/]]
 */
object NaryTreePreorderTraversal {

  // root -> left -> right
  def preorder(root: Node): List[Int] = {
    val stack = mutable.Stack.empty[Node]
    val acc = mutable.ListBuffer.empty[Int]

    var currentNode = root

    while (currentNode != null) {
      acc += currentNode.value
      stack.pushAll(currentNode.children.reverse)

      if (stack.isEmpty) {
        currentNode = null
      } else {
        currentNode = stack.pop()
      }
    }

    acc.toList
  }

}
