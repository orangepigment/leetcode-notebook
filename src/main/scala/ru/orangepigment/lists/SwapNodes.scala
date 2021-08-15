package ru.orangepigment.lists

import ru.orangepigment.data.ListNode

import scala.annotation.tailrec

/**
 * [[https://leetcode.com/problems/swapping-nodes-in-a-linked-list/]]
 */
object SwapNodes {

  def swapNodes(head: ListNode, k: Int): ListNode = {
    if (head.next != null) {
      val fast = getNodeByNumber(head, k)
      swapNodesRecursive(
        head,
        head,
        fast,
        fast
      )
    }
    head
  }

  @tailrec
  def swapNodesRecursive(
                          head: ListNode,
                          slow: ListNode,
                          fast: ListNode,
                          firstNodeToSwap: ListNode
                        ): Unit = {
    if (fast.next == null) {
      // Swap
      val tmp = firstNodeToSwap.x
      firstNodeToSwap.x = slow.x
      slow.x = tmp
    } else {
      swapNodesRecursive(
        head,
        slow.next,
        fast.next,
        firstNodeToSwap,
      )
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

  def main(args: Array[String]): Unit = {
    swapNodes(
      //new ListNode(1, new ListNode(2, null)),
      new ListNode(1, new ListNode(2, new ListNode(3, null))),
      1
    )
  }

}
