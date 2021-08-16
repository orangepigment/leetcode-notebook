package ru.orangepigment.trees

import ru.orangepigment.data.TreeNode

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

/**
 * [[https://leetcode.com/problems/binary-tree-level-order-traversal/]]
 */
object LevelOrder {

  def levelOrder(root: TreeNode): List[List[Int]] = {
    val acc = ListBuffer.empty[List[Int]]

    if (root != null) {
      val queue = mutable.Queue.empty[TreeNode]
      queue.enqueue(root)

      while (queue.nonEmpty) {
        val currentLevelValues = ListBuffer.empty[Int]
        for (_ <- queue.indices) {
          val currentNode = queue.dequeue()
          Option(currentNode.left).foreach(queue.enqueue)
          Option(currentNode.right).foreach(queue.enqueue)
          currentLevelValues += currentNode.value
        }
        acc += currentLevelValues.toList
      }
    }

    acc.toList
  }

}
