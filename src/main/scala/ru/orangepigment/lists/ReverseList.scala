package ru.orangepigment.lists

import ru.orangepigment.data.ListNode

import scala.annotation.tailrec

/**
 * [[https://leetcode.com/problems/reverse-linked-list]]
 */
object ReverseList {

  def reverseList(head: ListNode): ListNode = {
    reverseRecursive(head)
  }

  @tailrec
  def reverseRecursive(current: ListNode, prev: ListNode = null): ListNode = {
    if (current == null) {
      prev
    } else if (prev == null) {
      val nxt = current.next
      current.next = null
      reverseRecursive(nxt, current)
    } else {
      val nxt = current.next
      current.next = prev
      reverseRecursive(nxt, current)
    }
  }

}
