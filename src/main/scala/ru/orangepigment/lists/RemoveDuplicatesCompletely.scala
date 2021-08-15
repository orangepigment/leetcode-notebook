package ru.orangepigment.lists

import ru.orangepigment.data.ListNode

import scala.annotation.tailrec

/**
 * [[https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii]]
 */
object RemoveDuplicatesCompletely {

  def deleteDuplicates(head: ListNode): ListNode = {
    deleteDuplicatesRecursive(head, head)
  }

  @tailrec
  def deleteDuplicatesRecursive(
                                 head: ListNode,
                                 current: ListNode,
                                 prev: ListNode = null,
                                 duplicated: Boolean = false): ListNode = {
    if (current == null) {
      head
    } else if (current.next == null) {
      if (duplicated) {
        if (prev != null) {
          prev.next = null
          head
        } else {
          null
        }
      } else {
        head
      }
    } else {
      if (current.x == current.next.x) {
        current.next = current.next.next
        deleteDuplicatesRecursive(head, current, prev, duplicated = true)
      } else if (duplicated) {
        if (prev == null) {
          deleteDuplicatesRecursive(current.next, current.next)
        } else {
          prev.next = current.next
          deleteDuplicatesRecursive(head, current.next, prev)
        }
      } else {
        deleteDuplicatesRecursive(head, current.next, current)
      }
    }
  }

}
