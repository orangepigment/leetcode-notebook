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
                      var value: Int,
                      var frequency: Int = 1,
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
        addNode(node)
        node.value

      case None => -1
    }
  }

  def put(key: Int, value: Int): Unit = {
    if (_capacity > 0) {
      cache.get(key) match {
        case Some(node) =>
          node.value = value
          node.frequency += 1
          removeNode(node)
          addNode(node)

        case None =>
          if (cache.size == _capacity) {
            cache.remove(head.get.key)
            removeNode(head.get)
          }
          val node = new Node(key, value)
          addNode(node)
          cache.put(key, node)
      }

      if (cache.size == _capacity && !cache.keySet.contains(key)) {
        cache.remove(head.get.key)
      }
    }
  }

  @annotation.tailrec
  private def addNode(node: Node, current: Option[Node] = head): Unit = {
    current match {
      case None =>
        tail match {
          case Some(tailNode) =>
            tailNode.next = Some(node)
            node.prev = tail
            tail = Some(node)
          case None =>
            head = Some(node)
            tail = Some(node)
        }
      case Some(currentNode) =>
        if (node.frequency < currentNode.frequency) {
          node.next = current
          currentNode.prev match {
            case Some(prevNode) =>
              prevNode.next = Some(node)
              node.prev = currentNode.prev
            case None =>
              head = Some(node)
          }
          currentNode.prev = Some(node)
        } else {
          addNode(node, currentNode.next)
        }
    }
  }

  private def removeNode(node: Node): Unit = {
    node.prev match {
      case Some(prevNode) => prevNode.next = node.next
      case None =>
        head = node.next
        head.foreach(n => n.prev = None)
    }

    node.next match {
      case Some(nextNode) => nextNode.prev = node.prev
      case None => tail = node.prev
    }

    node.next = None
    node.prev = None
  }

}
