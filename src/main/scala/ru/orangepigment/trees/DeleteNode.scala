package ru.orangepigment.trees

import ru.orangepigment.data.TreeNode

import scala.annotation.tailrec

/**
 * [[https://leetcode.com/problems/delete-node-in-a-bst/]]
 */
object DeleteNode {

  def deleteNode(root: TreeNode, key: Int): TreeNode = {
    deleteNodeRecursive(root, key, root, isRoot = true)
  }


  @tailrec
  private def deleteNodeRecursive(
                                   node: TreeNode,
                                   key: Int,
                                   root: TreeNode,
                                   isRoot: Boolean = false
                                 ): TreeNode = {
    if (node == null) { // key not found
      root
    } else if (isRoot && node.value == key) { // Delete root
      (node.left, node.right) match {
        case (null, null) => null
        case (leftChild, null) => leftChild
        case (null, rightChild) => rightChild
        case (leftChild, rightChild) =>
          val (replacement, replacementParent) = findFarthestRightChild(leftChild)
          if (replacementParent != null) {
            replacementParent.right = replacement.left
          }
          if (replacement != leftChild) {
            replacement.left = leftChild
          }
          replacement.right = rightChild
          replacement
      }
    } else if (key > node.value) {
      // work with right direction
      if (node.right != null && node.right.value == key) {
        val nodeToDelete = node.right
        (nodeToDelete.left, nodeToDelete.right) match {
          case (null, null) =>
            node.right = null
          case (leftChild, null) =>
            node.right = leftChild
          case (null, rightChild) =>
            node.right = rightChild
          case (leftChild, rightChild) =>
            val (replacement, replacementParent) = findFarthestRightChild(leftChild)
            if (replacementParent != null) {
              replacementParent.right = replacement.left
            }
            if (replacement != leftChild) {
              replacement.left = leftChild
            }
            replacement.right = rightChild
            node.right = replacement
        }
        root
      } else {
        deleteNodeRecursive(node.right, key, root)
      }
    } else {
      // work with left direction
      if (node.left != null && node.left.value == key) {
        val nodeToDelete = node.left
        (nodeToDelete.left, nodeToDelete.right) match {
          case (null, null) =>
            node.left = null
          case (leftChild, null) =>
            node.left = leftChild
          case (null, rightChild) =>
            node.left = rightChild
          case (leftChild, rightChild) =>
            val (replacement, replacementParent) = findFarthestRightChild(leftChild)
            if (replacementParent != null) {
              replacementParent.right = replacement.left
            }
            if (replacement != leftChild) {
              replacement.left = leftChild
            }
            replacement.right = rightChild
            node.left = replacement
        }
        root
      } else {
        // Continue search
        deleteNodeRecursive(node.left, key, root)
      }
    }
  }

  @tailrec
  private def findFarthestRightChild(node: TreeNode, parent: TreeNode = null): (TreeNode, TreeNode) = {
    node.right match {
      case null => (node, parent)
      case _ => findFarthestRightChild(node.right, node)
    }
  }

}
