package ru.orangepigment.lists

import ru.orangepigment.data.ListNode

import scala.annotation.tailrec

/**
 * [[https://leetcode.com/problems/middle-of-the-linked-list/]]
 */
object MiddleOfTheLinkedList {

  def middleNode(head: ListNode): ListNode = {
    val listLength = countListLength(head)
    getNodeByNumber(head, listLength / 2 + 1)
  }

  @tailrec
  def countListLength(current: ListNode, acc: Int = 0): Int = {
    if (current == null) {
      acc
    } else {
      countListLength(current.next, acc + 1)
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

  @tailrec
  def slowAndFastSearch(slow: ListNode, fast: ListNode): ListNode = {
    if (fast == null || fast.next == null) {
      slow
    } else {
      slowAndFastSearch(slow.next, fast.next.next)
    }
  }

}
