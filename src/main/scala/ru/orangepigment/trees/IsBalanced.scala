package ru.orangepigment.trees

import ru.orangepigment.data.TreeNode

import scala.collection.mutable

/**
 * [[https://leetcode.com/problems/balanced-binary-tree/]]
 */
object IsBalanced {

  // Another approach is to compare minDepth and maxDepth of the tree
  def isBalanced(root: TreeNode): Boolean = {
    if (root == null) {
      true
    } else {
      var isBalanced = true
      val queue = mutable.Queue.empty[TreeNode]
      queue.enqueue(root)
      while (queue.nonEmpty && isBalanced) {
        val currentNode = queue.dequeue()
        Option(currentNode.left).foreach(queue.enqueue)
        Option(currentNode.right).foreach(queue.enqueue)
        isBalanced = currentNode == null || Math.abs(treeHeight(currentNode.left) - treeHeight(currentNode.right)) <= 1
      }
      isBalanced
    }
  }

  def treeHeight(root: TreeNode): Int = {
    if (root != null) {
      var height = 0
      val queue = mutable.Queue.empty[TreeNode]
      queue.enqueue(root)

      while (queue.nonEmpty) {
        for (_ <- queue.indices) {
          val currentNode = queue.dequeue()
          Option(currentNode.left).foreach(queue.enqueue)
          Option(currentNode.right).foreach(queue.enqueue)
        }
        height += 1
      }
      height
    } else {
      0
    }
  }

}
