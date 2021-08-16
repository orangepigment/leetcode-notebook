package ru.orangepigment.trees

import ru.orangepigment.data.TreeNode

import scala.collection.mutable

object PreorderTraversal {

  // root -> left -> right
  def preorderTraversal(root: TreeNode): List[Int] = {
    val stack = mutable.Stack.empty[TreeNode]
    val acc = mutable.ListBuffer.empty[Int]

    var currentNode = root

    while (currentNode != null) {
      acc += currentNode.value
      Option(currentNode.right).foreach(stack.push)
      Option(currentNode.left).foreach(stack.push)

      if (stack.isEmpty) {
        currentNode = null
      } else {
        currentNode = stack.pop()
      }
    }

    acc.toList
  }

}
