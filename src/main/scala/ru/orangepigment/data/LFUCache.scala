package ru.orangepigment.data

import scala.collection.mutable

/**
 * [[https://leetcode.com/problems/lfu-cache/]]
 *
 * Your ru.orangepigment.data.LFUCache object will be instantiated and called as such:
 * var obj = new ru.orangepigment.data.LFUCache(capacity)
 * var param_1 = obj.get(key)
 * obj.put(key,value)
 */

class LFUCache(_capacity: Int) {

  private class Node(
                      val key: Int,
                      val value: Int,
                      var frequency: Int,
                      var next: Option[Node] = None,
                      var prev: Option[Node] = None,
                    )

  private var head: Option[Node] = None
  private var tail: Option[Node] = None
  private val cache = mutable.Map.empty[Int, Node]

  def get(key: Int): Int = {
    cache.get(key) match {
      case Some(node) =>
        node.frequency += 1
        removeNode(node)
        // ToDo: Insert the node back to list
        node.value

      case None => -1
    }
  }

  def put(key: Int, value: Int): Unit = {
    cache.get(key) match {
      case Some(node) =>
        node.frequency += 1
        removeNode(node)
        // ToDo: Insert the node back to list

      case None =>
        if (cache.size == _capacity) {
          cache.remove(head.get.key)
          removeNode(head.get)
        }
        val node = new Node(key, value, 1)
        // ToDo: Add new node
        cache.put(key, node)
    }

    if (cache.size == _capacity && !cache.keySet.contains(key)) {
      cache.remove(head.get.key)
    }

  }

  private def addNode(node: Node): Unit = {
    if (head.isEmpty) {
      head = Some(node)
      tail = Some(node)
    } else {
      // ToDo: implement
      ???
    }
  }

  private def removeNode(node: Node): Unit = {
    node.prev match {
      case Some(prevNode) => prevNode.next = node.next
      case None => head = node.next
    }

    node.next match {
      case Some(nextNode) => nextNode.prev = node.prev
      case None => tail = node.prev
    }
  }

}
