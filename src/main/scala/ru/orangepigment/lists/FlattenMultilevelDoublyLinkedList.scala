package ru.orangepigment.lists

object FlattenMultilevelDoublyLinkedList {

  class Node(var _value: Int) {
    var value: Int = _value
    var prev: Node = null
    var next: Node = null
    var child: Node = null
  }

  def flatten(head: Node): Node = {
    if (head != null) {
      flattenRecursive(head)
    }
    head
  }

  // returns tail
  private def flattenRecursive(current: Node): Node = {
    if (current.next == null) {
      flattenChild(current)
    } else if (current.child == null) {
      flattenRecursive(current.next)
    } else {
      val trailing = current.next
      val childTail = flattenChild(current)
      childTail.next = trailing
      trailing.prev = childTail
      flattenRecursive(trailing)
    }
  }

  private def flattenChild(parent: Node): Node = {
    if (parent.child == null) {
      parent
    } else {
      val childTail = flattenRecursive(parent.child)
      parent.child.prev = parent
      parent.next = parent.child
      parent.child = null
      childTail
    }
  }

}
