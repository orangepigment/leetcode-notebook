package ru.orangepigment.lists

import ru.orangepigment.data.ListNode

import scala.annotation.tailrec

object InsertionSortList {

  def insertionSortList(head: ListNode): ListNode = {
    insertionSortListRecursive(head.next, new ListNode(head.x))
  }

  @tailrec
  def insertionSortListRecursive(source: ListNode, target: ListNode): ListNode = {
    if (source == null) {
      target
    } else {
      insertionSortListRecursive(source.next, insertIntoSorted(source.x, target, target))
    }
  }

  @tailrec
  def insertIntoSorted(
                        newValue: Int,
                        targetHead: ListNode,
                        current: ListNode,
                        targetPrev: ListNode = null
                      ): ListNode = {
    if (current == null) {
      val newNode = new ListNode(newValue, current)
      targetPrev.next = newNode
      targetHead
    } else if (newValue <= current.x) {
      val newNode = new ListNode(newValue, current)
      if (targetPrev == null) {
        newNode
      } else {
        targetPrev.next = newNode
        targetHead
      }
    } else {
      insertIntoSorted(
        newValue,
        targetHead,
        current.next,
        current
      )
    }
  }

}
