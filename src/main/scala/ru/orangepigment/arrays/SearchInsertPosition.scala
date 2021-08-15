package ru.orangepigment.arrays

import scala.annotation.tailrec

/**
 * [[https://leetcode.com/problems/search-insert-position]]
 */
object SearchInsertPosition {

  def searchInsert(nums: Array[Int], target: Int): Int = {
    searchRecursive(0, nums.length - 1, nums, target)
  }

  @tailrec
  def searchRecursive(
                       leftIndex: Int,
                       rightIndex: Int,
                       nums: Array[Int],
                       target: Int
                     ): Int = {
    if (rightIndex - leftIndex <= 1) {
      if (target < nums(leftIndex)) {
        leftIndex
      } else if (target > nums(rightIndex)) {
        rightIndex + 1
      } else {
        rightIndex
      }
    } else {
      val middleIndex = (leftIndex + rightIndex) / 2
      val elem = nums(middleIndex)
      if (elem == target) {
        middleIndex
      } else if (elem > target) {
        searchRecursive(leftIndex, middleIndex, nums, target)
      } else {
        searchRecursive(middleIndex, rightIndex, nums, target)
      }
    }
  }

}
