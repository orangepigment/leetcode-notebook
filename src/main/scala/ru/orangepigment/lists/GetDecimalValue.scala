package ru.orangepigment.lists

import ru.orangepigment.data.ListNode

import scala.annotation.tailrec

/**
 * [[https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/]]
 */
object GetDecimalValue {

  def getDecimalValue(head: ListNode): Int = {
    getDecimalRecursive(head)
  }

  @tailrec
  def getDecimalRecursive(current: ListNode, acc: Int = 0): Int = {
    if (current.next == null) {
      (acc << 1) + current.x
    } else {
      getDecimalRecursive(current.next, (acc << 1) + current.x)
    }
  }

}
