package ru.orangepigment.lists

import ru.orangepigment.data.ListNode

import scala.annotation.tailrec

/**
 * [[https://leetcode.com/problems/split-linked-list-in-parts/]]
 */
object SplitListToParts {

  def splitListToParts(head: ListNode, k: Int): Array[ListNode] = {
    if (head == null) {
      new Array[ListNode](k)
    } else if (k == 1) {
      Array(head)
    } else {
      val listLength = countListLength(head)
      val groupSize = listLength / k
      val oversizedGroupsNum = listLength % k
      val groups = splitListToPartsRecursive(head, head, groupSize, oversizedGroupsNum = oversizedGroupsNum)

      // If groups num is less than k add extra empty elements
      if (groups.size == k) {
        groups.toArray
      } else {
        (groups ++ List.fill[ListNode](k - groups.size)(null)).toArray
      }
    }
  }

  def splitListToPartsRecursive(
                                 head: ListNode,
                                 current: ListNode,
                                 groupSize: Int,
                                 counter: Int = 1,
                                 acc: List[ListNode] = List.empty[ListNode],
                                 oversizedGroupsNum: Int = 0
                               ): List[ListNode] = {
    if (head == null) {
      acc
    } else {
      if (oversizedGroupsNum == 0) {
        if (counter == groupSize) {
          val newHead = current.next
          current.next = null
          head +: splitListToPartsRecursive(newHead, newHead, groupSize)
        } else {
          splitListToPartsRecursive(head, current.next, groupSize, counter + 1, acc)
        }
      } else {
        if (counter == groupSize + 1) {
          val newHead = current.next
          current.next = null
          head +: splitListToPartsRecursive(newHead, newHead, groupSize, oversizedGroupsNum = oversizedGroupsNum - 1)
        } else {
          splitListToPartsRecursive(head, current.next, groupSize, counter + 1, acc, oversizedGroupsNum)
        }
      }
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

}
