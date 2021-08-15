package ru.orangepigment.lists

import ru.orangepigment.data.ListNode

import scala.annotation.tailrec

/**
 * [[https://leetcode.com/problems/remove-duplicates-from-sorted-list]]
 */
object DeleteDuplicates {

  def deleteDuplicates(head: ListNode): ListNode = {
    deleteDuplicatesRecursive(head, head)
  }

  @tailrec
  def deleteDuplicatesRecursive(head: ListNode, current: ListNode): ListNode = {
    if (current == null || current.next == null) {
      head
    } else {
      if (current.x == current.next.x) {
        current.next = current.next.next
        deleteDuplicatesRecursive(head, current)
      } else {
        deleteDuplicatesRecursive(head, current.next)
      }
    }
  }

}
