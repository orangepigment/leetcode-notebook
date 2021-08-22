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
    if (leftIndex < rightIndex) {
      val middleIndex = (leftIndex + rightIndex) / 2
      if (nums(middleIndex) == target) {
        middleIndex
      } else if (target < nums(middleIndex)) {
        searchRecursive(leftIndex, middleIndex - 1, nums, target)
      } else {
        searchRecursive(middleIndex + 1, rightIndex, nums, target)
      }
    } else if (nums(leftIndex) >= target) {
      leftIndex
    } else {
      leftIndex + 1
    }
  }

}
