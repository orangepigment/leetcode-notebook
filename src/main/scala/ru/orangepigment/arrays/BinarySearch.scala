package ru.orangepigment.arrays

import scala.annotation.tailrec

/**
 * [[https://leetcode.com/problems/binary-search]]
 */
object BinarySearch {

  def search(nums: Array[Int], target: Int): Int = {
    binarySearch(nums, target)()
  }

  @tailrec
  def binarySearch(nums: Array[Int], target: Int)(leftIndex: Int = 0, rightIndex: Int = nums.length - 1): Int = {
    if (leftIndex <= rightIndex) {
      val middleIndex = (leftIndex + rightIndex) / 2
      if (target == nums(middleIndex)) {
        middleIndex
      } else if (target > nums(middleIndex)) {
        binarySearch(nums, target)(middleIndex + 1, rightIndex)
      } else {
        binarySearch(nums, target)(leftIndex, middleIndex - 1)
      }
    } else {
      -1
    }
  }

}
