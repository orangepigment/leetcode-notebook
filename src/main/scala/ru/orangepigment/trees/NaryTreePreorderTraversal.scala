package ru.orangepigment.trees

import scala.collection.mutable

/**
 * [[https://leetcode.com/problems/n-ary-tree-preorder-traversal/]]
 */
object NaryTreePreorderTraversal {

  class Node(var _value: Int) {
    var value: Int = _value
    var children: List[Node] = List()
  }

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
