package ru.orangepigment.trees

import ru.orangepigment.data.TreeNode

/**
 * [[https://leetcode.com/problems/binary-tree-inorder-traversal/]]
 */
object InorderTraversal {

  // ToDo: add iterative solution
  // left -> root -> right
  def inorderTraversal(root: TreeNode): List[Int] = {
    inorderTraversalRecursive(root)
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
