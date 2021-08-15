package ru.orangepigment.lists

import ru.orangepigment.data.ListNode

import scala.annotation.tailrec

/**
 * [[https://leetcode.com/problems/merge-two-sorted-lists]]
 */
object MergeTwoLists {

  def mergeTwoLists(l1: ListNode, l2: ListNode): ListNode = {
    recursiveMerge(l1, l2, l2)
  }

  @tailrec
  def recursiveMerge(
                      source: ListNode,
                      target: ListNode,
                      targetHead: ListNode,
                      targetPrev: ListNode = null
                    ): ListNode = {
    if (source == null) {
      targetHead
    } else if (targetHead == null) {
      source
    } else if (target == null) {
      targetPrev.next = source
      targetHead
    } else {
      if (target.x < source.x) {
        recursiveMerge(source, target.next, targetHead, target)
      } else {
        val src = source.next
        source.next = target

        val (head, prev) =
          if (targetPrev != null) {
            targetPrev.next = source
            (targetHead, source)
          } else {
            (source, source)
          }

        recursiveMerge(src, target, head, prev)
      }
    }
  }

}
