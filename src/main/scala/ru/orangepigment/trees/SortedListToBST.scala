package ru.orangepigment.trees

import ru.orangepigment.data.{ListNode, TreeNode}

import scala.annotation.tailrec

/**
 * [[https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/]]
 */
object SortedListToBST {

  def sortedListToBST(head: ListNode): TreeNode = {
    if (head == null) {
      null
    } else if (head.next == null) {
      new TreeNode(head.x, null, null)
    } else {
      val (middle, middlePrev) = getMiddleAndPrevNode(head, head)
      if (middlePrev != null) {
        middlePrev.next = null
      }
      new TreeNode(
        middle.x,
        sortedListToBST(head),
        sortedListToBST(middle.next)
      )
    }
  }

  @tailrec
  def getMiddleAndPrevNode(slow: ListNode, fast: ListNode, slowPrev: ListNode = null): (ListNode, ListNode) = {
    if (fast == null || fast.next == null) {
      (slow, slowPrev)
    } else {
      getMiddleAndPrevNode(slow.next, fast.next.next, slow)
    }
  }

}
