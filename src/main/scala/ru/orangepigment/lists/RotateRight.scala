package ru.orangepigment.lists

import ru.orangepigment.data.ListNode

import scala.annotation.tailrec

/**
 * [[https://leetcode.com/problems/rotate-list]]
 */
object RotateRight {

  def rotateRight(head: ListNode, k: Int): ListNode = {
    val (tail, length) = findTailAndLength(head)

    if (length <= 1 || k % length == 0) {
      head
    } else {
      rotate(head, head, tail, length - k % length)
    }
  }

  @tailrec
  def rotate(current: ListNode, head: ListNode, tail: ListNode, steps: Int): ListNode = {
    // require(steps >= 1)
    if (steps == 1) {
      val newHead = current.next
      tail.next = head
      current.next = null

      newHead
    } else {
      rotate(current.next, head, tail, steps - 1)
    }
  }

  @tailrec
  def findTailAndLength(current: ListNode, length: Int = 0): (ListNode, Int) = {
    if (current == null) {
      (null, length)
    } else if (current.next == null) {
      (current, length + 1)
    } else {
      findTailAndLength(current.next, length + 1)
    }
  }

}
