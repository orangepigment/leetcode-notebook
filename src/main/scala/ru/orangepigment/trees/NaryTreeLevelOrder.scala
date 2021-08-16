package ru.orangepigment.trees

import ru.orangepigment.data.Node

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

/**
 * [[https://leetcode.com/problems/n-ary-tree-level-order-traversal/]]
 */
object NaryTreeLevelOrder {

  def levelOrder(root: Node): List[List[Int]] = {
    val acc = ListBuffer.empty[List[Int]]

    if (root != null) {
      val queue = mutable.Queue.empty[Node]
      queue.enqueue(root)

      while (queue.nonEmpty) {
        val currentLevelValues = ListBuffer.empty[Int]
        for (_ <- queue.indices) {
          val currentNode = queue.dequeue()
          queue.enqueueAll(currentNode.children)
          currentLevelValues += currentNode.value
        }
        acc += currentLevelValues.toList
      }
    }

    acc.toList
  }

}
