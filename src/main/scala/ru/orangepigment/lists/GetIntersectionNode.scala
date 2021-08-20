package ru.orangepigment.lists

import ru.orangepigment.data.ListNode

import scala.annotation.tailrec

object GetIntersectionNode {

  def getIntersectionNode(headA: ListNode, headB: ListNode): ListNode = {
    val aLength = countListLength(headA)
    val bLength = countListLength(headB)
    val diff = aLength - bLength
    if (diff > 0) {
      findMeetingPointIfExists(getNodeByNumber(headA, diff + 1), headB)
    } else if (diff < 0) {
      findMeetingPointIfExists(headA, getNodeByNumber(headB, Math.abs(diff) + 1))
    } else {
      findMeetingPointIfExists(headA, headB)
    }
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
  def findMeetingPointIfExists(currentA: ListNode, currentB: ListNode): ListNode = {
    if (currentA == null) {
      null
    } else if (currentA == currentB) {
      currentA
    } else {
      findMeetingPointIfExists(currentA.next, currentB.next)
    }
  }

}
