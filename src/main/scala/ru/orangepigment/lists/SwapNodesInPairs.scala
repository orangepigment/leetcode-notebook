package ru.orangepigment.lists

import ru.orangepigment.data.ListNode

import scala.annotation.tailrec

/**
 * [[https://leetcode.com/problems/swap-nodes-in-pairs]]
 */
object SwapNodesInPairs {

  def swapPairs(head: ListNode): ListNode = {
    swapRecursive(head, head)
  }

  @tailrec
  def swapRecursive(head: ListNode, current: ListNode, prev: ListNode = null): ListNode = {
    if (current == null || current.next == null) {
      head
    } else {
      val newHead =
        if (prev == null) {
          head.next
        } else {
          prev.next = current.next
          head
        }
      val newPrev = current
      val next = current.next.next

      current.next.next = current
      current.next = next

      swapRecursive(newHead, next, newPrev)
    }
  }

}
