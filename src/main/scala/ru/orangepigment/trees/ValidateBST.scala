package ru.orangepigment.trees

import ru.orangepigment.data.TreeNode

import scala.collection.mutable

/**
 * [[https://leetcode.com/problems/validate-binary-search-tree/]]
 */
object ValidateBST {

  def isValidBST(root: TreeNode): Boolean = {
    if (root != null) {
      val stack = mutable.Stack.empty[TreeNode]
      var currentNode = root
      var prevNode: TreeNode = null

      // left -> node -> right traversal
      while (stack.nonEmpty || currentNode != null) {
        while (currentNode != null) {
          stack.push(currentNode)
          currentNode = currentNode.left
        }

        currentNode = stack.pop()
        // prevNode is either left child or parent, so currentNode must be greater than prevNode
        if (prevNode != null && currentNode.value <= prevNode.value) {
          return false
        }

        prevNode = currentNode
        currentNode = currentNode.right
      }

    }

    true
  }

  def main(args: Array[String]): Unit = {
    println(
      isValidBST(
        new TreeNode(
          4,
          new TreeNode(1, null, null),
          new TreeNode(3, null, null)
        )
      ).toString
    )
  }

}
