package ru.orangepigment.lists

import ru.orangepigment.data.ListNode

import scala.annotation.tailrec

/**
 * [[https://leetcode.com/problems/delete-node-in-a-linked-list]]
 */
object DeleteNode {
  def deleteNode(node: ListNode): Unit = {
    deleteRecursive(node)
  }

  @tailrec
  def deleteRecursive(node: ListNode, prev: ListNode = null): Unit = {
    if (node.next == null) {
      prev.next = null
    } else {
      node.x = node.next.x
      deleteRecursive(node.next, node)
    }
  }

}
