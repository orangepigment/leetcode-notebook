package ru.orangepigment.trees

import ru.orangepigment.data.TreeNode

import scala.collection.mutable

/**
 * [[https://leetcode.com/problems/binary-tree-inorder-traversal/]]
 */
object InorderTraversal {

  // left -> root -> right
  def inorderTraversal(root: TreeNode): List[Int] = {
    val acc = mutable.ListBuffer.empty[Int]
    val stack = mutable.Stack.empty[TreeNode]
    var currentNode = root
    while (stack.nonEmpty || currentNode != null) {
      while (currentNode != null) {
        stack.push(currentNode)
        currentNode = currentNode.left
      }

      currentNode = stack.pop()
      acc += currentNode.value

      currentNode = currentNode.right
    }
    acc.toList
  }

  def inorderTraversalRecursive(node: TreeNode, acc: List[Int] = List.empty[Int]): List[Int] = {
    if (node == null) {
      acc
    } else {
      Option(node.left).map(leftNode => inorderTraversalRecursive(leftNode, acc)).getOrElse(acc) :+
        node.value :++
        Option(node.right).map(leftNode => inorderTraversalRecursive(leftNode, acc)).getOrElse(List.empty[Int])
    }
  }

}
