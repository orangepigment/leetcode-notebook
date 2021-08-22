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
class MyDoublyLinkedList() {

  class ListNode(_value: Int = 0, _next: ListNode = null, _prev: ListNode = null) {
    var next: ListNode = _next
    var prev: ListNode = _prev
    var value: Int = _value
  }

  /** Initialize your data structure here. */
  private var head: ListNode = _
  private var last: ListNode = _
  private var length: Int = 0

  /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
  def get(index: Int): Int = {
    index match {
      case _ if index >= length => -1
      case 0 => head.value
      case _ if index == (length - 1) => last.value
      case _ if index <= length / 2 => getNodeAtIndexFromHeadRecursive(index).value
      case _ => getNodeAtIndexFromLastRecursive(length - 1 - index).value
    }
  }

  @tailrec
  private def getNodeAtIndexFromHeadRecursive(index: Int, pos: Int = 0, current: ListNode = head): ListNode = {
    if (pos == index) {
      current
    } else {
      getNodeAtIndexFromHeadRecursive(index, pos + 1, current.next)
    }
  }

  @tailrec
  private def getNodeAtIndexFromLastRecursive(index: Int, pos: Int = 0, current: ListNode = last): ListNode = {
    if (pos == index) {
      current
    } else {
      getNodeAtIndexFromLastRecursive(index, pos + 1, current.prev)
    }
  }

  /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
  def addAtHead(`val`: Int): Unit = {
    val newNode = new ListNode(`val`, head)
    if (head != null) {
      head.prev = newNode
    }
    head = newNode
    length += 1
    if (length == 1) {
      last = head
    }
  }

  /** Append a node of value val to the last element of the linked list. */
  def addAtTail(`val`: Int): Unit = {
    if (head == null) {
      addAtHead(`val`)
    } else {
      val newNode = new ListNode(`val`, _prev = last)
      last.next = newNode
      last = newNode
      length += 1
    }
  }

  /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
  def addAtIndex(index: Int, `val`: Int): Unit = {
    if (index <= length) {
      index match {
        case 0 => addAtHead(`val`)
        case _ if index == length => addAtTail(`val`)
        case _ =>
          // Can be optimized for case when index > length /2 (search starting from last)
          val nodeAfterNew = getNodeAtIndexFromHeadRecursive(index)
          nodeAfterNew.prev = new ListNode(`val`, nodeAfterNew, nodeAfterNew.prev)
          nodeAfterNew.prev.prev.next = nodeAfterNew.prev
          length += 1
      }
    }
  }

  /** Delete the index-th node in the linked list, if the index is valid. */
  def deleteAtIndex(index: Int): Unit = {
    if (index < length) {
      if (index == 0) {
        head = head.next
        if (head != null) {
          head.prev = null
        }
      } else if (index == length - 1) {
        last = last.prev
        last.next = null
      } else {
        // Can be optimized for case when index > length /2 (search starting from last)
        val nodeToDelete = getNodeAtIndexFromHeadRecursive(index)
        nodeToDelete.prev.next = nodeToDelete.next
        nodeToDelete.next.prev = nodeToDelete.prev
      }
      length -= 1
    }
  }

}

object MyDoublyLinkedList {

  def main(args: Array[String]): Unit = {
    val myLinkedList = new MyDoublyLinkedList
    myLinkedList.addAtHead(1)
    myLinkedList.deleteAtIndex(0)
  }

}
