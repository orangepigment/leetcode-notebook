package ru.orangepigment.trees

import ru.orangepigment.data.TreeNode

import scala.collection.mutable

/**
 * [[https://leetcode.com/problems/binary-tree-postorder-traversal/]]
 */
object PostorderTraversal {

  // left -> right -> root
  def postorderTraversal(root: TreeNode): List[Int] = {
    val stack = mutable.Stack.empty[TreeNode]
    val acc = mutable.ListBuffer.empty[Int]

    var currentNode = root

    while (currentNode != null) {
      Option(currentNode.left).foreach(stack.push)
      Option(currentNode.right).foreach(stack.push)
      currentNode.value +=: acc

      if (stack.isEmpty) {
        currentNode = null
      } else {
        currentNode = stack.pop()
      }
    }

    acc.toList
  }

}
