package ru.orangepigment.data

import scala.annotation.tailrec

/**
 * [[https://leetcode.com/problems/design-linked-list]]
 *
 * Your MyLinkedList object will be instantiated and called as such:
 * var obj = new MyLinkedList()
 * var param_1 = obj.get(index)
 * obj.addAtHead(`val`)
 * obj.addAtTail(`val`)
 * obj.addAtIndex(index,`val`)
 * obj.deleteAtIndex(index)
 */
class MyLinkedList() {

  class ListNode(_value: Int = 0, _next: ListNode = null) {
    var next: ListNode = _next
    var value: Int = _value
  }

  /** Initialize your ru.orangepigment.data structure here. */
  private var head: ListNode = _
  private var length: Int = 0

  /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
  def get(index: Int): Int = {
    if (index < length) {
      getNodeAtIndexRecursive(index).value
    } else {
      -1
    }
  }

  @tailrec
  private def getNodeAtIndexRecursive(index: Int, pos: Int = 0, current: ListNode = head): ListNode = {
    if (pos == index) {
      current
    } else {
      getNodeAtIndexRecursive(index, pos + 1, current.next)
    }
  }

  /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
  def addAtHead(`val`: Int): Unit = {
    val newNode = new ListNode(`val`, head)
    head = newNode
    length += 1
  }

  /** Append a node of value val to the last element of the linked list. */
  def addAtTail(`val`: Int): Unit = {
    if (head == null) {
      addAtHead(`val`)
    } else {
      addAtTailRecursive(`val`)
      length += 1
    }
  }

  @tailrec
  private def addAtTailRecursive(`val`: Int, current: ListNode = head): Unit = {
    if (current.next == null) {
      current.next = new ListNode(`val`, null)
    } else {
      addAtTailRecursive(`val`, current.next)
    }
  }

  /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
  def addAtIndex(index: Int, `val`: Int): Unit = {
    if (index <= length) {
      index match {
        case 0 => addAtHead(`val`)
        case l if l == length => addAtTail(`val`)
        case _ =>
          val nodeBeforeNew = getNodeAtIndexRecursive(index - 1)
          nodeBeforeNew.next = new ListNode(`val`, nodeBeforeNew.next)
          length += 1
      }
    }
  }

  /** Delete the index-th node in the linked list, if the index is valid. */
  def deleteAtIndex(index: Int): Unit = {
    if (index < length) {
      if (index == 0) {
        head = head.next
      } else {
        val nodeBeforeDeleted = getNodeAtIndexRecursive(index - 1)
        nodeBeforeDeleted.next = nodeBeforeDeleted.next.next
      }
      length -= 1
    }
  }

}
