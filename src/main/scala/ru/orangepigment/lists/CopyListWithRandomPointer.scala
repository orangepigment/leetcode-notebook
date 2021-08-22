package ru.orangepigment.lists

import scala.annotation.tailrec
import scala.collection.mutable.ArrayBuffer

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
    // an array of original nodes
    val arrayOfNodes = listToArray(head)
    //  node number to number of the node pointed on by "random"
    val randomPointers = arrayOfNodes.map { case (node, _) =>
      arrayOfNodes.find { case (pointedNode, _) => node.random == pointedNode }
        .map(_._2).getOrElse(-1)
    }

    val copiedList = arrayOfNodes.map { case (node, i) =>
      new Node(node.value) -> i
    }
    copiedList.foreach { case (node, i) =>
      node.next =
        if (i + 1 < copiedList.length) {
          copiedList(i + 1)._1
        } else {
          null
        }
      node.random =
        randomPointers(i) match {
          case -1 => null
          case j => copiedList(j)._1
        }
    }
    copiedList.headOption.map(_._1).orNull
  }

  @tailrec
  def listToArray(current: Node, acc: ArrayBuffer[Node] = ArrayBuffer.empty[Node]): Array[(Node, Int)] = {
    if (current == null) {
      acc.toArray.zipWithIndex
    } else {
      listToArray(current.next, acc :+ current)
    }
  }

}
