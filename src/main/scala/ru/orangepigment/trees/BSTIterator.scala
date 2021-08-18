package ru.orangepigment.trees

import ru.orangepigment.data.TreeNode

import scala.collection.mutable

/**
 * [[https://leetcode.com/problems/binary-search-tree-iterator/]]
 *
 * Your BSTIterator object will be instantiated and called as such:
 * var obj = new BSTIterator(root)
 * var param_1 = obj.next()
 * var param_2 = obj.hasNext()
 */
class BSTIterator(_root: TreeNode) {

  private val stack = mutable.Stack.empty[TreeNode]
  private var currentNode: TreeNode = _root

  def next(): Int = {
    moveToNextNode()
    val res = currentNode.value
    currentNode = currentNode.right
    res
  }

  def hasNext(): Boolean = {
    stack.nonEmpty || currentNode != null
  }

  private def moveToNextNode(): Unit = {
    if (stack.nonEmpty || currentNode != null) {
      while (currentNode != null) {
        stack.push(currentNode)
        currentNode = currentNode.left
      }
      // We at the most left node now
      currentNode = stack.pop()
    }
  }

}
