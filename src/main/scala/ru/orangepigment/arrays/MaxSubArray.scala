package ru.orangepigment.arrays

/**
 * [[https://leetcode.com/problems/maximum-subarray/]]
 */
object MaxSubArray {

  def maxSubArray(nums: Array[Int]): Int = {
    var max = Int.MinValue
    var acc = 0
    for (i <- nums.indices) {
      acc += nums(i)
      if (acc > max) {
        max = acc
      }
      if (acc < 0) {
        acc = 0
      }
    }
    max
  }

}
