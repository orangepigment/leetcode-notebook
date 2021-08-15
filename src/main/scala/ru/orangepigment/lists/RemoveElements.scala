package ru.orangepigment.lists

import ru.orangepigment.data.ListNode

import scala.annotation.tailrec

/**
 * [[https://leetcode.com/problems/remove-linked-list-elements]]
 */
object RemoveElements {

  def removeElements(head: ListNode, `val`: Int): ListNode = {
      removeRecursive(head, head, null, `val`)
  }

  @tailrec
  def removeRecursive(head: ListNode, current: ListNode, prev: ListNode, value: Int): ListNode = {
    if (current == null) {
      head
    } else {
      if (current.x == value) {
        if (prev == null) {
          removeRecursive(current.next, current.next, null, value)
        } else {
          prev.next = current.next
          removeRecursive(head, current.next, prev, value)
        }
      } else {
        removeRecursive(head, current.next, current, value)
      }
    }
  }

}
