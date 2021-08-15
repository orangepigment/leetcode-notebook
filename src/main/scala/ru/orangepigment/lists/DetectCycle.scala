package ru.orangepigment.lists

import ru.orangepigment.data.ListNode

import scala.annotation.tailrec

/**
 * [[https://leetcode.com/problems/linked-list-cycle-ii/]]
 */
object DetectCycle {

  def detectCycle(head: ListNode): ListNode = {
    if (head == null || head.next == null) {
      null
    } else {
      detectCycleRecursive(head, head, head.next)
    }
  }

  @tailrec
  def detectCycleRecursive(
                            head: ListNode,
                            slow: ListNode,
                            fast: ListNode,
                            metInCycle: Boolean = false
                          ): ListNode = {
    if (slow == fast) {
      if (metInCycle) {
        slow
      } else {
        detectCycleRecursive(
          head,
          slow.next,
          head,
          metInCycle = true
        )
      }
    } else if (fast.next == null || fast.next.next == null) {
      null
    } else {
      detectCycleRecursive(
        head,
        slow.next,
        if (metInCycle) fast.next else fast.next.next,
        metInCycle
      )
    }
  }

}
