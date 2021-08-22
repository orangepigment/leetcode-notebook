package ru.orangepigment.trees

import ru.orangepigment.data.TreeNode

import scala.collection.mutable

/**
 * [[https://leetcode.com/problems/symmetric-tree/]]
 */
object SymmetricTree {

  def isSymmetric(root: TreeNode): Boolean = {
    val leftQueue = mutable.Queue.empty[TreeNode]
    val rightQueue = mutable.Queue.empty[TreeNode]

    leftQueue.enqueue(root.left)
    rightQueue.enqueue(root.right)

    while (leftQueue.nonEmpty || rightQueue.nonEmpty) {
      if (leftQueue.size != rightQueue.size) {
        return false
      }

      for (_ <- leftQueue.indices) {
        val leftNode = leftQueue.dequeue()
        val rightNode = rightQueue.dequeue()
        if (getNodeValue(leftNode) != getNodeValue(rightNode)) {
          return false
        }

        if (leftNode != null) {
          leftQueue.enqueue(leftNode.left)
          leftQueue.enqueue(leftNode.right)
        }

        if (rightNode != null) {
          rightQueue.enqueue(rightNode.right)
          rightQueue.enqueue(rightNode.left)
        }
      }
    }
    true
  }

  private def getNodeValue(node: TreeNode): Int = {
    Option(node).map(_.value).getOrElse(111)
  }

}
