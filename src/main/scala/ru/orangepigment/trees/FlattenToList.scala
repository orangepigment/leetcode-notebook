package ru.orangepigment.trees

import ru.orangepigment.data.TreeNode

import scala.collection.mutable

/**
 * [[https://leetcode.com/problems/flatten-binary-tree-to-linked-list/]]
 */
object FlattenToList {

  def flatten(root: TreeNode): Unit = {
    val stack = mutable.Stack.empty[TreeNode]

    var currentNode = root

    while (currentNode != null) {
      Option(currentNode.right).foreach(stack.push)
      Option(currentNode.left).foreach(stack.push)

      if (stack.isEmpty) {
        currentNode = null
      } else {
        currentNode.left = null
        currentNode.right = stack.pop()
        currentNode = currentNode.right
      }
    }
  }

}
