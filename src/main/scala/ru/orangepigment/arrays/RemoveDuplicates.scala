package ru.orangepigment.arrays

import scala.annotation.tailrec

/**
 * [[https://leetcode.com/problems/remove-duplicates-from-sorted-array]]
 */
object RemoveDuplicates {

  def removeDuplicates(nums: Array[Int]): Int = {
    if (nums.isEmpty) {
      0
    } else {
      var n = 0
      for (i <- 1 until nums.length) {
        if (nums(i) != nums(n)) {
          n += 1
          nums(n) = nums(i)
        }
      }
      n + 1
    }
  }

  @tailrec
  def removeDuplicatesRecursive(nums: Array[Int], indexOfFixedElement: Int = 0, currentIndex: Int = 0): Int = {
    if (currentIndex == nums.length) {
      indexOfFixedElement + 1
    } else if (nums(indexOfFixedElement) == nums(currentIndex)) {
      removeDuplicatesRecursive(nums, indexOfFixedElement, currentIndex + 1)
    } else {
      nums(indexOfFixedElement + 1) = nums(currentIndex)
      removeDuplicatesRecursive(nums, indexOfFixedElement + 1, currentIndex + 1)
    }
  }

  def removeDuplicatesFullShift(nums: Array[Int]): Int = {
    var uniqueCount = 0
    var i = 0
    var maxIndex = nums.length - 1
    while (i < maxIndex + 1) {
      if (i == maxIndex || nums(i) != nums(i + 1)) {
        i += 1
        uniqueCount += 1
      } else {
        for (j <- i + 1 to maxIndex) {
          nums(j - 1) = nums(j)
        }
        nums(maxIndex) = 1000
        maxIndex -= 1
      }
    }
    uniqueCount
  }

}
