package ru.orangepigment.lists

import ru.orangepigment.data.ListNode

import scala.annotation.tailrec

object RemoveNthNodeFromEnd {

  def removeNthFromEnd(head: ListNode, n: Int): ListNode = {
    removeNthFromEndRecursive(head, head, getNodeByNumber(head, n))
  }

  @tailrec
  def removeNthFromEndRecursive(
                                 head: ListNode,
                                 slow: ListNode,
                                 fast: ListNode,
                                 slowPrev: ListNode = null
                               ): ListNode = {
      if (fast.next == null) {
        if (slowPrev == null) {
          head.next
        } else {
          slowPrev.next = slow.next
          head
        }
      } else {
        removeNthFromEndRecursive(head, slow.next, fast.next, slow)
      }
  }

  // 1-based
  @tailrec
  def getNodeByNumber(current: ListNode, target: Int, currentNumber: Int = 1): ListNode = {
    if (currentNumber == target) {
      current
    } else {
      getNodeByNumber(current.next, target, currentNumber + 1)
    }
  }

}
