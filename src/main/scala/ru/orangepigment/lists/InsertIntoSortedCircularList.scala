package ru.orangepigment.lists


/**
 * [[https://leetcode.com/problems/insert-into-a-sorted-circular-linked-list/]]
 */
object InsertIntoSortedCircularList {

  class Node(var _value: Int) {
    var value: Int = _value
    var next: Node = null
  }


  def insert(head: Node, insertVal: Int): Node = {
    insertRecursive(head, head, insertVal)
  }

  @annotation.tailrec
  def insertRecursive(head: Node, current: Node, insertVal: Int): Node = {
    if (head == null) {
      val newNode = new Node(insertVal)
      newNode.next = newNode
      newNode
    } else if ((current.next == head) || // One node list or we have traversed the whole list and didn't find a position to insert
      (insertVal >= current.value && insertVal <= current.next.value) || // we can insert value if it's between current and current.next
      (current.value > current.next.value && (insertVal >= current.value || insertVal <= current.next.value)) // or if insertValue is new max or min and we are at the current maximum
    ) {
      val newNode = new Node(insertVal)
      newNode.next = current.next
      current.next = newNode
      head
    } else {
      insertRecursive(head, current.next, insertVal)
    }
  }

}
