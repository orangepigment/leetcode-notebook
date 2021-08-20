package ru.orangepigment.lists

import ru.orangepigment.data.ListNode

import scala.annotation.tailrec

/**
 * [[https://leetcode.com/problems/odd-even-linked-list/]]
 */
object OddEvenList {

  def oddEvenList(head: ListNode): ListNode = {
    if (head != null) {
      val evenHead = head.next
      val (oddLast, _) = splitIntoOddEvenLists(head, evenHead)
      oddLast.next = evenHead
    }
    head
  }

  @tailrec
  def splitIntoOddEvenLists(oddLast: ListNode, evenLast: ListNode): (ListNode, ListNode) = {
    if (evenLast == null) {
      (oddLast, null)
    } else if (evenLast.next == null) {
      (oddLast, evenLast)
    } else {
      val nextEven = evenLast.next.next
      oddLast.next = evenLast.next
      evenLast.next = nextEven
      splitIntoOddEvenLists(oddLast.next, evenLast.next)
    }
  }

}
