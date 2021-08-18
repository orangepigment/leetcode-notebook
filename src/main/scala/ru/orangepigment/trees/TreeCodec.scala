package ru.orangepigment.trees

import ru.orangepigment.data.TreeNode

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

/**
 * [[https://leetcode.com/problems/serialize-and-deserialize-binary-tree/]]
 */
class TreeCodec {
  // Encodes a list of strings to a single string.
  def serialize(root: TreeNode): String = {
    val acc = ListBuffer.empty[String]
    // Level order traversal and write values in order
    if (root != null) {
      val queue = mutable.Queue.empty[Either[String, TreeNode]]
      queue.enqueue(Right(root))

      while (queue.nonEmpty) {
        val currentLevelValues = ListBuffer.empty[String]
        for (_ <- queue.indices) {
          val currentNode = queue.dequeue()
          currentNode match {
            case Left(nullStr) => currentLevelValues += nullStr
            case Right(node) =>
              queue.enqueue(
                Option(node.left).map(Right.apply).getOrElse(Left("null"))
              )
              queue.enqueue(
                Option(node.right).map(Right.apply).getOrElse(Left("null"))
              )
              currentLevelValues += node.value.toString
          }
        }
        acc ++= currentLevelValues
      }
      acc.mkString(":").replaceAll("(:null)*$", "")
    } else {
      ""
    }
  }

  // Decodes a single string to a list of strings.
  def deserialize(data: String): TreeNode = {
    // Use  queue, i-th elem is always at the start of the queue
    if (data.isEmpty) {
      null
    } else {
      val queue = mutable.Queue.empty[TreeNode]
      val nodeStrings = data.split(":")
      val root = new TreeNode(nodeStrings(0).toInt)
      queue.enqueue(root)
      for (i <- nodeStrings.indices if queue.nonEmpty) {
        val currentNode = queue.dequeue()
        if (2 * i + 1 < nodeStrings.length) {
          val maybeLeftChild = nodeStringToMaybeNode(nodeStrings(2 * i + 1))
          maybeLeftChild.foreach { child =>
            currentNode.left = child
            queue.enqueue(child)
          }
        }

        if (2 * i + 2 < nodeStrings.length) {
          val maybeRightChild = nodeStringToMaybeNode(nodeStrings(2 * i + 2))
          maybeRightChild.foreach { child =>
            currentNode.right = child
            queue.enqueue(child)
          }
        }
      }
      root
    }
  }

  private def nodeStringToMaybeNode(str: String): Option[TreeNode] = {
    str match {
      case "null" => None
      case strInt =>
        Some(new TreeNode(strInt.toInt))
    }
  }
}

object TreeCodec {

  def main(args: Array[String]): Unit = {
    val codec = new TreeCodec()
    val serialized = codec.serialize(
      new TreeNode(
        1,
        new TreeNode(2),
        new TreeNode(
          3,
          new TreeNode(4),
          new TreeNode(5)
        )
      )
    )
    println(serialized)
    codec.deserialize(serialized)
  }

}
