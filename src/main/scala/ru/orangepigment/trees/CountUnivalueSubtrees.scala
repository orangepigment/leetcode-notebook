package ru.orangepigment.trees

import ru.orangepigment.data.TreeNode

/**
 * [[https://leetcode.com/problems/count-univalue-subtrees/]]
 */
object CountUnivalueSubtrees {

  def countUnivalSubtrees(root: TreeNode): Int = {
    countUnivalSubtreesRecursive(root)._1
  }

  def countUnivalSubtreesRecursive(current: TreeNode, parentValue: Option[Int] = None): (Int, Boolean) = {
    if (current == null) {
      0 -> true
    } else if (current.left == null && current.right == null) {
      1 -> (current.value == parentValue.getOrElse(current.value))
    } else {
      val (leftCount, leftUnival) = countUnivalSubtreesRecursive(current.left, Some(current.value))
      val (rightCount, rightUnival) = countUnivalSubtreesRecursive(current.right, Some(current.value))

      val isUnivalWithParent = current.value == parentValue.getOrElse(current.value) && leftUnival && rightUnival

      if (leftUnival && rightUnival) {
        leftCount + rightCount + 1 -> isUnivalWithParent
      } else {
        leftCount + rightCount -> isUnivalWithParent
      }
    }
  }

}
