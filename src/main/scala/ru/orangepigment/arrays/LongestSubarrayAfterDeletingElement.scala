package ru.orangepigment.arrays

/**
 * [[https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/]]
 */
object LongestSubarrayAfterDeletingElement {

  def longestSubarray(nums: Array[Int]): Int = {
    var max = 0
    var counter = 0
    var counterWithDelete = 0

    for (n <- nums) {
      n match {
        case 1 =>
          counter += 1
          counterWithDelete += 1

        case 0 =>
          counterWithDelete = counter
          counter = 0
      }

      if (counterWithDelete > max) {
        max = counterWithDelete
      }
    }

    if (max == nums.length) max - 1 else max
  }

}
