package ru.orangepigment.trees

import ru.orangepigment.data.TreeNode

/**
 * [[https://leetcode.com/problems/path-sum/]]
 */
object PathSum {

  def hasPathSum(root: TreeNode, targetSum: Int): Boolean = {
    hasPathSumRecursive(root, targetSum)
  }

  def hasPathSumRecursive(current: TreeNode, targetSum: Int, acc: Int = 0): Boolean = {
    if (current == null) {
      false
    } else if (current.left == null && current.right == null && (acc + current.value) == targetSum) {
      true
    } else if (hasPathSumRecursive(current.left, targetSum, acc + current.value) ||
      hasPathSumRecursive(current.right, targetSum, acc + current.value)) {
      true
    } else {
      false
    }
  }

}
