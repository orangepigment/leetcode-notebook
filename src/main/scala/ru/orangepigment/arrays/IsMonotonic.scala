package ru.orangepigment.arrays

/**
 * [[https://leetcode.com/problems/monotonic-array/]]
 */
object IsMonotonic {

  def isMonotonic(nums: Array[Int]): Boolean = {
    if (nums(0) < nums(nums.length - 1)) {
      for (i <- 1 until nums.length) {
        if (nums(i) < nums(i - 1)) {
          return false
        }
      }
      true
    } else if (nums(0) == nums(nums.length - 1)) {
      for (i <- 1 until nums.length) {
        if (nums(i) != nums(i - 1)) {
          return false
        }
      }
      true
    } else {
      for (i <- 1 until nums.length) {
        if (nums(i) > nums(i - 1)) {
          return false
        }
      }
      true
    }
  }

}
