package ru.orangepigment.trees

import ru.orangepigment.data.TreeNode

/**
 * [[https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/]]
 */
object SortedArrayToBST {

  def sortedArrayToBST(nums: Array[Int]): TreeNode = {
    sortedArrayToBSTRecursive(nums, 0, nums.length - 1)
  }

  def sortedArrayToBSTRecursive(nums: Array[Int], left: Int, right: Int): TreeNode = {
    if (left > right) {
      null
    } else {
      val middle = (left + right) / 2
      new TreeNode(
        nums(middle),
        sortedArrayToBSTRecursive(nums, left, middle - 1),
        sortedArrayToBSTRecursive(nums, middle + 1, right)
      )
    }
  }

}
