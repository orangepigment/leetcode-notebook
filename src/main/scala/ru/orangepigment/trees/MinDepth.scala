package ru.orangepigment.trees

import ru.orangepigment.data.TreeNode

import scala.collection.mutable

/**
 * [[https://leetcode.com/problems/minimum-depth-of-binary-tree/]]
 */
object MinDepth {

  def minDepth(root: TreeNode): Int = {
    if (root != null) {
      var depth = 1
      val queue = mutable.Queue.empty[TreeNode]
      queue.enqueue(root)

      while (queue.nonEmpty) {
        for (_ <- queue.indices) {
          val currentNode = queue.dequeue()
          if (currentNode.left == null && currentNode.right == null) {
            return depth
          }

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
