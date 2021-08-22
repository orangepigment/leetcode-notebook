package ru.orangepigment.lists

import scala.collection.mutable

/**
 * [[https://leetcode.com/problems/copy-list-with-random-pointer/]]
 */
object CopyListWithRandomPointer {

  class Node(var _value: Int) {
    var value: Int = _value
    var next: Node = null
    var random: Node = null
  }

  def copyRandomList(head: Node): Node = {
    val nodesToCopies = mutable.Map.empty[Node, Node]

    def copyRecursive(node: Node): Node = {
      if (node == null) {
        null
      } else {
        val copy = new Node(node.value)
        nodesToCopies += node -> copy
        copy.next = nodesToCopies.getOrElse(node.next, copyRecursive(node.next))
        copy.random = nodesToCopies.getOrElse(node.random, copyRecursive(node.random))

        copy
      }
    }

    copyRecursive(head)
  }

}
