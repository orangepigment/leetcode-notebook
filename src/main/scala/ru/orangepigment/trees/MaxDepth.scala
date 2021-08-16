package ru.orangepigment.trees

import ru.orangepigment.data.TreeNode

import scala.collection.mutable

/**
 * [[https://leetcode.com/problems/maximum-depth-of-binary-tree/]]
 */
object MaxDepth {

  def maxDepth(root: TreeNode): Int = {
    if (root != null) {
      var depth = 0
      val queue = mutable.Queue.empty[TreeNode]
      queue.enqueue(root)

      while (queue.nonEmpty) {
        for (_ <- queue.indices) {
          val currentNode = queue.dequeue()
          Option(currentNode.left).foreach(queue.enqueue)
          Option(currentNode.right).foreach(queue.enqueue)
        }
        depth += 1
      }
      depth
    } else {
      0
    }
  }

}
